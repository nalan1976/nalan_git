package hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.hibernate.FlushMode;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

public class HibernateTest {
    private static SessionFactory sessionFactory;

    @BeforeClass
    public static void beforeClass() {
/**为测试临时注释掉
 *  String[] configLocations = new String[]{
                "applicationContext-hbt.xml"};*
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext(configLocations);
        sessionFactory = ctx.getBean("sessionFactory", SessionFactory.class);
 */
    }

    /*
        @Before
        public void setUp() {
    //id自增主键从0开始
    //        final String createTableSql = "create memory table test" +
    //                "(id int GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY, " +
    //                "name varchar(100))";
            final String createTableSql = "CREATE TABLE runoob_tbl(\n" +
                    "   runoob_id INT UNSIGNED AUTO_INCREMENT,\n" +
                    "   runoob_title VARCHAR(100) NOT NULL,\n" +
                    "   PRIMARY KEY ( runoob_id )\n" +
                    ")";
            sessionFactory.openSession().createNativeQuery(createTableSql).executeUpdate();
        }
        @After
        public void tearDown() {
            final String dropTableSql = "drop table test";
            sessionFactory.openSession().
                    createQuery(dropTableSql).executeUpdate();
        }*/
/*    @Test
    public void testFirst() {
        Session session = sessionFactory.openSession();
//        session.beginTransaction();
        Transaction transaction = null;
        try {
            transaction = beginTransaction(session);
            UserModel model = new UserModel();
            model.setMyName("myName");
            session.save(model);
        } catch (RuntimeException e) {
            rollbackTransaction(transaction);
            throw e;
        } finally {
            commitTransaction(session);
        }
    }*/

    private Transaction beginTransaction(Session session) {
        Transaction transaction = session.beginTransaction();
        //Hibernate5中不需要了，加上会出错
//        transaction.begin();
        return transaction;
    }

    private void rollbackTransaction(Transaction transaction) {
        if (transaction != null) {
            transaction.rollback();
        }
    }

    private void commitTransaction(Session session) {
        session.getTransaction().commit();
        session.close();
    }

    @Test
//    @Transactional
        public void testHibernateTemplate() {

        HibernateTemplate hibernateTemplate =
                new HibernateTemplate(sessionFactory);
        final UserModel model = new UserModel();
//        hibernateTemplate.getSessionFactory().getCurrentSession().setHibernateFlushMode(FlushMode.AUTO);
//        sessionFactory.getCurrentSession().setHibernateFlushMode(FlushMode.AUTO);
/*     //Hibernate 5.2以前的写法
        FlushMode flushMode=session.getFlushMode();
        session.setFlushMode(FlushMode.AUTO);*/
        model.setMyName("myName1");
//        getHibernateTemplate().setFlushMode(HibernateTemplate.FLUSH_EAGER);
        hibernateTemplate.save(model);
        //通过回调允许更复杂操作
        hibernateTemplate.execute(new HibernateCallback<Void>() {
            @Override
            public Void doInHibernate(Session session)
                    throws HibernateException/*, SQLException*/ {
                session.save(model);
                return null;
            }
        });
    }
}
