package com.nalan.framework.hibernate.test.mapping;

import org.hibernate.Session;
import java.util.*;
import java.io.Serializable;
import com.nalan.util.hibernate.HibernateUtil;

public class One2MulJoinTableOneway {

    public static class Person1ntab {
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

        public Person1ntab() {
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
    public static void One2MulJoinTableOnewayCall(){

        Session session = HibernateUtil.getCurrentSession();
        session = HibernateUtil.getCurrentSession();
        session.beginTransaction();

        Person1ntab psn=new Person1ntab();
        psn.setAge(41);
        psn.setName("nalan");

        Address1nfk addr=new Address1nfk();
        Address1nfk addr2=new Address1nfk();
        addr.setAddressdetail("郑州市经三路");
        addr2.setAddressdetail("上海市银都路");
/**以下为各种set和保存方法的测试结果和数据库端收到的命令：


 * */
        psn.getAddresses().add(addr);
        psn.getAddresses().add(addr2);


        session.save(addr);
        session.save(addr2);
        session.save(psn);

        session.getTransaction().commit();

        session.close();
    }
    public static void getObject(){
        Session session = HibernateUtil.getCurrentSession();
        session = HibernateUtil.getCurrentSession();
        session.beginTransaction();

        Person1ntab psn= session.load(Person1ntab.class, 1);
        System.out.println("person.name=" + psn.getName());

        Set<Address1nfk> addrSet = new HashSet<>();
        addrSet = psn.getAddresses();
        Iterator<Address1nfk> itAddr = addrSet.iterator();
        while(itAddr.hasNext())
            System.out.println("Address details =" + itAddr.next().getAddressdetail());



//        Address1nfk addr=new Address1nfk();
    }

    public static void main(String args[]){
        One2MulJoinTableOnewayCall();
        getObject();

        HibernateUtil.close();
    }
}
