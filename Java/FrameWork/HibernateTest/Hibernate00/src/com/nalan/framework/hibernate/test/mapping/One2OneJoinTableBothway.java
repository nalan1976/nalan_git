package com.nalan.framework.hibernate.test.mapping;

import com.nalan.util.hibernate.HibernateUtil;
import org.hibernate.Session;

public class One2OneJoinTableBothway {

    public static class Person121tab2way {
        private int personid;
        private String name;
        private int age;

        public Address121tab2way getAddress11tab_sx() {
            return address11tab_sx;
        }

        public void setAddress11tab_sx(Address121tab2way address11tab_sx) {
            this.address11tab_sx = address11tab_sx;
        }

        private Address121tab2way address11tab_sx;

        public Person121tab2way() {
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



    }
    public static class Address121tab2way {
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

        public Address121tab2way() {
        }

        private int addressid;
        private String addressdetail;
        private Person121tab2way person11tab_sx;

        public Person121tab2way getPerson11tab_sx() {
            return person11tab_sx;
        }

        public void setPerson11tab_sx(Person121tab2way person11tab_sx) {
            this.person11tab_sx = person11tab_sx;
        }


    }

    public static void One2OneJoinTableBothwayCall(){

        Session session = HibernateUtil.getCurrentSession();
        session = HibernateUtil.getCurrentSession();
        session.beginTransaction();

        Person121tab2way psn=new Person121tab2way();
        psn.setAge(41);
        psn.setName("nalan");

        Address121tab2way addr=new Address121tab2way();
        addr.setAddressdetail("郑州市经三路");
/**以下为各种set和保存方法的测试结果和数据库端收到的命令：
 Person对象维护关系

 2个对象都set，都保存
 所有数据都正常保存

 2017-08-31T09:23:53.194649Z	  132 Query	insert into person_tab2way (name, age) values ('nalan', 41)
 2017-08-31T09:23:53.198691Z	  132 Query	insert into ADDRESS_11tab_sx (addressdetail) values ('郑州市经三路')
 2017-08-31T09:23:53.204458Z	  132 Query	insert into join_11tab_sx (addressid, personid) values (1, 1)


 只set Person对象 psn.setAddress11tab_sx(addr)，都保存
 所有数据都正常保存
 2017-08-31T09:37:23.939134Z	  134 Query	insert into person_tab2way (name, age) values ('nalan', 41)
 2017-08-31T09:37:23.943928Z	  134 Query	insert into ADDRESS_11tab_sx (addressdetail) values ('郑州市经三路')
 2017-08-31T09:37:23.958548Z	  134 Query	insert into join_11tab_sx (addressid, personid) values (1, 1)


 2个对象都set，只保存Person，
 只保存Person数据表，报异常：org.hibernate.internal.ExceptionMapperStandardImpl mapManagedFlushFailure
 ERROR: HHH000346: Error during managed flush [org.hibernate.TransientObjectException: object references an unsaved transient instance - save the transient instance beforeQuery flushing: com.nalan.framework.hibernate.test.mapping.One2OneJoinTableBothway$Address121tab2way]
 2017-08-31T12:38:05.622033Z	  139 Query	insert into person_tab2way (name, age) values ('nalan', 41)
 2017-08-31T12:38:05.630333Z	  139 Query	rollback

 2个对象都set，只保存Address，
 只保存Address数据表，报异常：Exception in thread "main" java.lang.IllegalStateException: org.hibernate.TransientObjectException: object references an unsaved transient instance - save the transient instance beforeQuery flushing: com.nalan.framework.hibernate.test.mapping.One2OneJoinTableBothway$Person121tab2way
 2017-08-31T13:07:47.959680Z	  144 Query	insert into ADDRESS_11tab_sx (addressdetail) values ('郑州市经三路')
 2017-08-31T13:07:47.964596Z	  144 Query	rollback


 只set Address对象addr.setPerson11tab_sx(psn)，但都保存
 连接表数据为空
 2017-08-31T09:29:59.277095Z	  133 Query	insert into person_tab2way (name, age) values ('nalan', 41)
 2017-08-31T09:29:59.282045Z	  133 Query	insert into ADDRESS_11tab_sx (addressdetail) values ('郑州市经三路')

 只set和保存Person对象
 只保存了Person对象的表，报异常：org.hibernate.internal.ExceptionMapperStandardImpl mapManagedFlushFailure
 ERROR: HHH000346: Error during managed flush [org.hibernate.TransientObjectException: object references an unsaved transient instance - save the transient instance beforeQuery flushing: com.nalan.framework.hibernate.test.mapping.One2OneJoinTableBothway$Address121tab2way]
 2017-08-31T11:46:33.340773Z	  135 Query	insert into person_tab2way (name, age) values ('nalan', 41)
 2017-08-31T11:46:33.349447Z	  135 Query	rollback

 只set Person对象，只保存Address对象
 只保存Address数据表
 2017-08-31T13:11:10.326443Z	  145 Query	insert into ADDRESS_11tab_sx (addressdetail) values ('郑州市经三路')
 2017-08-31T13:11:10.333021Z	  145 Query	rollback

 只set和保存Address对象
 连接表未保存
 2017-08-31T12:29:31.603076Z	  137 Query	insert into ADDRESS_11tab_sx (addressdetail) values ('郑州市经三路')
 2017-08-31T12:29:31.606640Z	  137 Query	insert into person_tab2way (name, age) values ('nalan', 41)

 只setAddress对象，只保存Person对象
 只保存了Person表
 2017-08-31T12:33:54.627210Z	  138 Query	insert into person_tab2way (name, age) values ('nalan', 41)
 * */
        psn.setAddress11tab_sx(addr);
//        addr.setPerson11tab_sx(psn);

        session.save(psn);
        session.save(addr);

        session.getTransaction().commit();

        session.close();
    }

    public static void main(String args[]){
        One2OneJoinTableBothwayCall();
//        getObject();

        HibernateUtil.close();
    }
}
