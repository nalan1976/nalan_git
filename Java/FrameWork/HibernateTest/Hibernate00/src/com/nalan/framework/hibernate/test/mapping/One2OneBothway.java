package com.nalan.framework.hibernate.test.mapping;
import org.hibernate.Session;
import com.nalan.util.hibernate.HibernateUtil;

public class One2OneBothway {
    /** 人－实体类 */
    public static class Person {
        private int id;
        private String name;
        private IdCard idCard;//引用IdCard对象

        public Person(){}
        public int getId() {return id;  }
        public void setId(int id) {this.id = id;}

        public String getName() {return name;}
        public void setName(String name){this.name = name;}

        public IdCard getIdCard() { return idCard;}
        public void setIdCard(IdCard idCard) {this.idCard = idCard;}
    }

    /**身份证-实体类*/
    public static class IdCard {
        private int id;
        private String cardNo;
        private Person person;//我自己加的

        public IdCard(){}
        public int getId() {return id;}
        public void setId(int id) {this.id = id;}

        public String getCardNo(){ return cardNo;}
        public void setCardNo(String cardNo) {this.cardNo = cardNo;}

        public Person getPerson() {return person;}
        public void setPerson(Person person) {this.person = person;}
    }

    public static void One2OneBothwayCall(){

        Session session = HibernateUtil.getCurrentSession();
        session = HibernateUtil.getCurrentSession();
        session.beginTransaction();

        One2OneBothway.IdCard idCard = new IdCard();
        idCard.setCardNo("88888888888888888888888");
        One2OneBothway.IdCard idCard2 = new IdCard();
        idCard2.setCardNo("1111111111111");


        One2OneBothway.Person person = new Person();
        person.setName("王五");
        person.setIdCard(idCard2);

        One2OneBothway.Person person1 = new Person();
        person1.setName("张三");
        person1.setIdCard(idCard);

        //可以只保存idCard但不能只保存person，why？
        session.save(person);
        session.save(person1);
        session.save(idCard);
        session.save(idCard2);
        //为何commit之前数据就保存了？
        //但t_person表中的idcard列直到执行完commit才填充？
        session.getTransaction().commit();

        session.close();
    }
    public static void getObject(){
        Session session = HibernateUtil.getCurrentSession();
        session.beginTransaction();

        Person person = session.get(Person.class, 2);
                //byId(One2OneBothway.Person.class).load(2);
        // load(One2OneBothway.Person.class, 2);
        System.out.println("person.name=" + person.getName());
        System.out.println("person.cardNo=" + person.getIdCard().getCardNo());

        IdCard idCard = (One2OneBothway.IdCard)session.load(IdCard.class, 2);
        System.out.println("idCard.cardNo=" + idCard.getCardNo());
        System.out.println("idCard.person.name=" + idCard.getPerson().getName());

        session.getTransaction().commit();

        session.close();
    }
    public static void main(String args[]){
//        One2OneUnilateralismForeignKeyCall();
        One2OneBothwayCall();
        getObject();

        HibernateUtil.close();
//        System.out.println(org.hibernate.cfg.Environment.VERSION);
    }
}
