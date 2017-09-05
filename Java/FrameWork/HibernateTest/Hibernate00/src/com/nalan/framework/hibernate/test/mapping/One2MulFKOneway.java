package com.nalan.framework.hibernate.test.mapping;

import com.nalan.util.hibernate.HibernateUtil;
import org.hibernate.Session;
import java.util.*;
import java.io.Serializable;

public class One2MulFKOneway {

    public static class Person1nfk implements Serializable {
        private int personid;
        private String name;
        private int age;
        private Set addresses = new HashSet();

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

        public Set getAddresses() {
            return addresses;
        }

        public void setAddresses(Set addresses) {
            this.addresses = addresses;
        }

        public Person1nfk() {
        }
    }

        public static class Address1nfk implements Serializable {
            private int addressid;
            private String addressdetail;

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

            public Address1nfk() {
            }
        }
    public static void One2OneJoinTableBothwayCall(){

        Session session = HibernateUtil.getCurrentSession();
        session = HibernateUtil.getCurrentSession();
        session.beginTransaction();

        Person1nfk psn=new Person1nfk();
        psn.setAge(41);
        psn.setName("nalan");

        Address1nfk addr=new Address1nfk();
        Address1nfk addr2=new Address1nfk();
        addr.setAddressdetail("郑州市经三路");
        addr2.setAddressdetail("上海市银都路");
/**以下为各种set和保存方法的测试结果和数据库端收到的命令：
 Person对象维护关系

 set Person对象，都保存
 一切正常
 2017-09-01T02:52:33.214770Z	  153 Query	insert into ADDRESS_1nfk (addressdetail) values ('郑州市经三路')
 2017-09-01T02:52:33.225850Z	  153 Query	insert into ADDRESS_1nfk (addressdetail) values ('上海市银都路')
 2017-09-01T02:52:33.247909Z	  153 Query	insert into PERSON_1nfk (name, age) values ('nalan', 41)
 2017-09-01T02:52:33.290876Z	  153 Query	update ADDRESS_1nfk set personid=1 where addressid=1
 2017-09-01T02:52:33.292933Z	  153 Query	update ADDRESS_1nfk set personid=1 where addressid=2


 * */
        psn.getAddresses().add(addr);
        psn.getAddresses().add(addr2);
//        addr.setPerson11tab_sx(psn);

        session.save(addr);
        session.save(addr2);
        session.save(psn);

        session.getTransaction().commit();

        session.close();
    }

    public static void main(String args[]){
        One2OneJoinTableBothwayCall();
//        getObject();

        HibernateUtil.close();
    }
}
