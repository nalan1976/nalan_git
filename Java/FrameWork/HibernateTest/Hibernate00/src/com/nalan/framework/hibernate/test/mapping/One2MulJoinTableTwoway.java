package com.nalan.framework.hibernate.test.mapping;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import java.util.*;
import java.io.Serializable;
import com.nalan.util.hibernate.HibernateUtil;

public class One2MulJoinTableTwoway {

    public static class Person1ntab_sx {
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

        public Person1ntab_sx() {
        }
    }

        public static class Address1ntab_sx {
            private int addressid;
            private String addressdetail;
            private Person1ntab_sx person1ntab_sx;

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

            public Person1ntab_sx getPerson1ntab_sx() {
                return person1ntab_sx;
            }

            public void setPerson1ntab_sx(Person1ntab_sx person1ntab_sx) {
                this.person1ntab_sx = person1ntab_sx;
            }

            public Address1ntab_sx() {
            }
        }
    public static void One2MulJoinTableTwowayCall(){

        Session session = HibernateUtil.getCurrentSession();
        session = HibernateUtil.getCurrentSession();
        session.beginTransaction();

        Person1ntab_sx psn=new Person1ntab_sx();
        psn.setAge(41);
        psn.setName("nalan");

        Address1ntab_sx addr=new Address1ntab_sx();
        Address1ntab_sx addr2=new Address1ntab_sx();
        addr.setAddressdetail("郑州市经三路");
        addr2.setAddressdetail("上海市银都路");
/**以下为各种set和保存方法的测试结果和数据库端收到的命令：
 Person对象维护关系



 * */
        psn.getAddresses().add(addr);
        psn.getAddresses().add(addr2);
        addr.setPerson1ntab_sx(psn);
        addr2.setPerson1ntab_sx(psn);

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

        Person1ntab_sx psn= session.load(Person1ntab_sx.class, 1);
        System.out.println("person.name=" + psn.getName());

        Set<Address1ntab_sx> addrSet = new HashSet<>();
        addrSet = psn.getAddresses();
        Iterator<Address1ntab_sx> itAddr = addrSet.iterator();
        while(itAddr.hasNext())
            System.out.println("Address details =" + itAddr.next().getAddressdetail());



//        Address1ntab_sx addr=new Address1ntab_sx();
    }

    public static void main(String args[]){
        One2MulJoinTableTwowayCall();
        getObject();

        HibernateUtil.close();
    }
}
