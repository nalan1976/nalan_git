package com.nalan.framework.hibernate.test.mapping;

import com.nalan.util.hibernate.HibernateUtil;
import org.hibernate.Session;

public class One2OnePrimaryKeyBothway {
        /** 人－实体类 */
        public static class  Person121PB implements java.io.Serializable {
            public Person121PB(){}

            private Long id;
            private String name;
            private Address121PB address;

            public Long getId() {
                return id;
            }

            public void setId(Long id) {
                this.id = id;
            }

            public Address121PB getAddress() {
                return address;
            }

            public void setAddress(Address121PB address) {
                this.address = address;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

        }

        /**身份证-实体类*/
        public static class Address121PB implements java.io.Serializable {
            public Address121PB() {}

            private Long id;
            private Person121PB person;
            private String detail;

            public Long getId() {
                return id;
            }

            public void setId(Long id) {
                this.id = id;
            }

            public Person121PB getPerson() {
                return person;
            }

            public void setPerson(Person121PB person) {
                this.person = person;
            }

            public String getDetail() {
                return detail;
            }

            public void setDetail(String detail) {
                this.detail = detail;
            }

        }

        public static void One2OnePrimaryBothwayCall(){

            Session session = HibernateUtil.getCurrentSession();
            session = HibernateUtil.getCurrentSession();
            session.beginTransaction();

            Address121PB addr = new Address121PB();
            addr.setDetail("上海");
            Person121PB psn = new Person121PB();
            psn.setName("nalan");


            /**只操作Address对象（即只addr.setPerson，只保存addr），则所有数据都被保存，猜测原因如下：
             * 1）因为Address对象对应的表中，主键生成依赖于Person对象，所以保存前必须完整填充才能正常入库；
             * 2）保存时，因为Address主键同时也是外键，所以插入数据库的顺序必须先插入对应的Person对象
             *
             * *只set Person对象的address（ 即psn.setAddress，即使2个对象都保存也会报异常“attempted to assign id from null one-to-one property”
             * *com.nalan.framework.hibernate.test.mapping.One2OnePrimaryKeyBothway$Address121PB.person]“，猜测原因如下：
             * 1）Person数据入库后，由于cascade=“all"的关系，会自动入库关联的Address对象，此时addr的主键为空，报异常；
             * 2）去除cascade关系
             *                  1.且只保存Person对象，不会报异常（已经验证通过），数据库中也只保存Person对象；
             *                  2.先保存Person对象，再保存Address对象，则Person数据可以正常入库，入库Address对象时，才报异常；
             *                  3.只保存Address对象，则Person对象也可正常入库。
             *
             * *2个对象都set之后，保存任意一个对象都可以，猜测原因如下：
             * 1）只保存address对象肯定可以，原因如第一条；
             * 2）只保存Person对象时，因为cascade="all"的原因，会自动保存关联对象入数据库
             * 3）去除cascade关系：
             *                  1.只保存Address对象，所有数据也可正常入库
             *                  2.只保存Person对象，则Address对象数据不会入库
             *
             * *只set Address对象(addr.setPerson)，保存任意一个对象应该也可以，但实测通不过：
             *
             *
             *
             * **总结：
             * 1）只操作Address对象（即只addr.setPerson，只保存addr），则所有数据都被保存
             * 2）问题：只set Address对象(addr.setPerson)，保存Person对象，则Address对象不能入库
             *                  1.感觉cascade="all"并没有完全起作用；
             * 3）注意：实际数据库插入顺序都是先Person再address；
             */

            addr.setPerson(psn);
//            psn.setAddress(addr);
//            session.save(psn);
            session.save(addr);
            session.getTransaction().commit();

            session.close();
        }
        public static void getObject(){
            Session session = HibernateUtil.getCurrentSession();
            session.beginTransaction();


            Person121PB person = session.get(Person121PB.class, 1L);
            System.out.println("person.name=" + person.getName());
            System.out.println("person.cardNo=" + person.getAddress().getDetail());

            Address121PB addr = session.load(Address121PB.class, 1L);
            System.out.println("idCard.cardNo=" + addr.getDetail());
            System.out.println("idCard.person.name=" + addr.getPerson().getName());

            session.getTransaction().commit();

            session.close();
        }
        public static void main(String args[]){
            One2OnePrimaryBothwayCall();
            getObject();

            HibernateUtil.close();
        }



}
