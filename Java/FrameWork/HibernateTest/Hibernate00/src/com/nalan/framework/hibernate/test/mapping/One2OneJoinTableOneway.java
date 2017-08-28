package com.nalan.framework.hibernate.test.mapping;

import com.nalan.util.hibernate.HibernateUtil;
import org.hibernate.Session;

public class One2OneJoinTableOneway {
    public static class Person121tab1way {
        private int personid;
        private String name;
        private int age;
        private Address121tab1way address11tab;

        public Person121tab1way() {
        }

        public int getPersonid() {
            return personid;
        }

        public void setPersonid(int personid) {
            this.personid = personid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public Address121tab1way getAddress11tab() {
            return address11tab;
        }

        public void setAddress11tab(Address121tab1way address11tab) {
            this.address11tab = address11tab;
        }

    }
        public static class Address121tab1way {
            public int getAddressid() {
                return addressid;
            }

            public void setAddressid(int addressid) {
                this.addressid = addressid;
            }

            public String getAddressdetail() {
                return addressdetail;
            }

            public void setAddressdetail(String addressdetail) {
                this.addressdetail = addressdetail;
            }

            public Address121tab1way() {
            }

            private int addressid;
            private String addressdetail;
        }

    public static void One2OneJoinTableOnewayCall(){

        Session session = HibernateUtil.getCurrentSession();
        session = HibernateUtil.getCurrentSession();
        session.beginTransaction();

        Person121tab1way psn=new Person121tab1way();
        psn.setAge(41);
        psn.setName("nalan");

        Address121tab1way addr=new Address121tab1way();
        addr.setAddressid(8);
        addr.setAddressdetail("郑州市经三路");

        psn.setAddress11tab(addr);
/**以下代码输出：
 2017-08-28T16:14:25.513127Z	  105 Query	insert into person_tab1way (name, age) values ('nalan', 41)
 2017-08-28T16:14:25.517295Z	  105 Query	insert into join_11tab (addressid, personid) values (null, 1)
 2017-08-28T16:14:25.528474Z	  105 Query	insert into address_tab1way (addressdetail, addressid) values ('郑州市经三路', 8)
 2017-08-28T16:14:25.529937Z	  105 Query	update join_11tab set addressid=8 where personid=1


 * */
//        session.save(psn);
//        session.save(addr);


/**以下代码输出：
 * 2017-08-28T16:12:34.618734Z	  104 Query	insert into address_tab1way (addressdetail, addressid) values ('郑州市经三路', 8)
 2017-08-28T16:12:34.621061Z	  104 Query	insert into person_tab1way (name, age) values ('nalan', 41)
 2017-08-28T16:12:34.624543Z	  104 Query	insert into join_11tab (addressid, personid) values (8, 1)

 * */
        //效率更高，因为先保存address不会触发连接表的操作，而先保存Person会触发连接表插入，最后又有一条update多了一条语句
        session.save(addr);//运行完这句代码，一条语句都没有发到数据库，why？
        session.save(psn);//运行完这句代码，一下子发过来3条语句，why？

//        addr.setPerson(psn);
//            psn.setAddress(addr);
//            session.save(psn);
//        session.save(addr);
        session.getTransaction().commit();

        session.close();
    }
    public static void getObject(){
/*        Session session = HibernateUtil.getCurrentSession();
        session.beginTransaction();


        One2OnePrimaryKeyBothway.Person121PB person = session.get(One2OnePrimaryKeyBothway.Person121PB.class, 1L);
        System.out.println("person.name=" + person.getName());
        System.out.println("person.cardNo=" + person.getAddress().getDetail());

        One2OnePrimaryKeyBothway.Address121PB addr = session.load(One2OnePrimaryKeyBothway.Address121PB.class, 1L);
        System.out.println("idCard.cardNo=" + addr.getDetail());
        System.out.println("idCard.person.name=" + addr.getPerson().getName());

        session.getTransaction().commit();

        session.close();*/
    }
    public static void main(String args[]){
        One2OneJoinTableOnewayCall();
//        getObject();

        HibernateUtil.close();
    }
}
