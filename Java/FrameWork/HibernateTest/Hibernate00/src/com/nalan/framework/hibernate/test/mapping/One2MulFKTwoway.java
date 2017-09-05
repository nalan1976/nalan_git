package com.nalan.framework.hibernate.test.mapping;
/**本例中学到：
 * 1）fetch的使用，但做实验没看出什么区别，还需要再验证
 * 2）Iterator的使用
 * */
import com.nalan.util.hibernate.HibernateUtil;
import org.hibernate.Session;
import java.util.*;
import java.io.Serializable;

public class One2MulFKTwoway {

    public static class Person1nfk_sx implements Serializable {
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

        public Person1nfk_sx() {
        }
    }

        public static class Address1nfk_sx implements Serializable {
            private int addressid;
            private String addressdetail;
            private Person1nfk_sx person1nfkSx;

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

            public Person1nfk_sx getPerson1nfkSx() {
                return person1nfkSx;
            }

            public void setPerson1nfkSx(Person1nfk_sx person1nfkSx) {
                this.person1nfkSx = person1nfkSx;
            }

            public Address1nfk_sx() {
            }
        }
    public static void One2OneJoinTableBothwayCall(){

        Session session = HibernateUtil.getCurrentSession();
        session = HibernateUtil.getCurrentSession();
        session.beginTransaction();

        Person1nfk_sx psn=new Person1nfk_sx();
        psn.setAge(41);
        psn.setName("nalan");

        Address1nfk_sx addr=new Address1nfk_sx();
        Address1nfk_sx addr2=new Address1nfk_sx();
        addr.setAddressdetail("郑州市经三路");
        addr2.setAddressdetail("上海市银都路");
/**以下为各种set和保存方法的测试结果和数据库端收到的命令：
 Address对象维护关系

 只set   Address对象，都保存
一切数据正常
 2017-09-01T03:42:10.083688Z	  159 Query	insert into PERSON_1nfk_sx (name, age) values ('nalan', 41)
 2017-09-01T03:42:10.097831Z	  159 Query	insert into ADDRESS_1nfk_sx (addressdetail, personid) values ('上海市银都路', 1)
 2017-09-01T03:42:10.106808Z	  159 Query	insert into ADDRESS_1nfk_sx (addressdetail, personid) values ('郑州市经三路', 1)

只set 并保存Address对象
 一切数据正常
 2017-09-01T03:49:46.758829Z	  161 Query	insert into PERSON_1nfk_sx (name, age) values ('nalan', 41)
 2017-09-01T03:49:46.763331Z	  161 Query	insert into ADDRESS_1nfk_sx (addressdetail, personid) values ('郑州市经三路', 1)
 2017-09-01T03:49:46.765836Z	  161 Query	insert into ADDRESS_1nfk_sx (addressdetail, personid) values ('上海市银都路', 1)

 * */
//        psn.getAddresses().add(addr);
//        psn.getAddresses().add(addr2);
        addr.setPerson1nfkSx(psn);
        addr2.setPerson1nfkSx(psn);

        session.save(addr);
        session.save(addr2);
//        session.save(psn);

        session.getTransaction().commit();

        session.close();
    }
    public static void getObject(){
        Session session = HibernateUtil.getCurrentSession();
        session = HibernateUtil.getCurrentSession();
        session.beginTransaction();

        Person1nfk_sx psn= session.load(Person1nfk_sx.class, 1);
        System.out.println("person.name=" + psn.getName());

        Set<Address1nfk_sx> addrSet = new HashSet<>();
        addrSet = psn.getAddresses();
        Iterator<Address1nfk_sx> itAddr = addrSet.iterator();
        while(itAddr.hasNext())
            System.out.println("Address details =" + itAddr.next().getAddressdetail());



//        Address1nfk_sx addr=new Address1nfk_sx();
    }

    public static void main(String args[]){
        One2OneJoinTableBothwayCall();
        getObject();

        HibernateUtil.close();
    }        
}
