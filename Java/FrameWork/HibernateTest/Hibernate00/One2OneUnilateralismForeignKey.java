import com.nalan.util.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
//import org.hibernate.Transaction;

//标准注解

//增加的注解
//import org.hibernate.annotations.GenericGenerator;


public class One2OneUnilateralismForeignKey {

    /** 人－实体类 */

    public class Person {
        private int id;
        private String name;
        private IdCard idCard;//引用IdCard对象

        public int getId() {return id;  }
        public void setId(int id) {this.id = id;}

        public String getName() {return name;}
        public void setName(String name){this.name = name;}

        public IdCard getIdCard() { return idCard;}
        public void setIdCard(IdCard idCard) {this.idCard = idCard;}
    }

    /**身份证-实体类*/

    public class IdCard {
        private int id;
        private String cardNo;

        public int getId() {return id;}
        public void setId(int id) {this.id = id;}

        public String getCardNo(){ return cardNo;}
        public void setCardNo(String cardNo) {this.cardNo = cardNo;}
    }
    public static void One2OneUnilateralismForeignKeyCall(){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        HibernateUtil sf = new HibernateUtil();
        sf.setSessionFactory(sessionFactory);

        Session session = sf.getCurrentSession();
        One2OneUnilateralismForeignKey.IdCard idCard = new One2OneUnilateralismForeignKey().new IdCard();
        idCard.setCardNo("88888888888888888888888");
        session.beginTransaction();
// 如果先不保存idCard，则出抛出Transient异常，因为idCard不是持久化状态。
        session.save(idCard);
        One2OneUnilateralismForeignKey.Person person = new One2OneUnilateralismForeignKey().new Person();
        person.setName("菜10");
        person.setIdCard(idCard);
        session.save(person);
        session.getTransaction().commit();

        sessionFactory.close();
    }
    public static void One2OnePrimaryKeyCall(){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        HibernateUtil sf = new HibernateUtil();
        sf.setSessionFactory(sessionFactory);

       Session session = sf.getCurrentSession();

        session = HibernateUtil.getCurrentSession();
        session.beginTransaction();
        One2OneUnilateralismForeignKey.IdCard idCard = new One2OneUnilateralismForeignKey().new IdCard();
        idCard.setCardNo("88888888888888888888888");

        One2OneUnilateralismForeignKey.Person person = new One2OneUnilateralismForeignKey().new Person();
        person.setName("菜10");
        person.setIdCard(idCard);

        //不会出现TransientObjectException异常
        //因为一对一主键关键映射中，默认了cascade属性。
        session.save(person);
        session.getTransaction().commit();
        sessionFactory.close();
    }
    public static void main1(String args[]){
//        One2OneUnilateralismForeignKeyCall();
        One2OnePrimaryKeyCall();

    }


}
