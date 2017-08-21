import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
//import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import java.util.Date;

/**
 * Created by DreamBoy on 2016/5/15.
 */
//测试类
public class StudentsTest {
    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;

    @Before
    public void init() {
        //创建配置对象
        Configuration config = new Configuration().configure();
//        config.addResource("Students.hbm.xml");
//        Configuration config = new AnnotationConfiguration().configure();
        //创建服务注册对象
//        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        //创建会话工厂对象
//        sessionFactory = config.buildSessionFactory(serviceRegistry);
        sessionFactory = config.buildSessionFactory();

        //会话对象
        session = sessionFactory.openSession();
        //开启事务
        transaction = session.beginTransaction();
    }

    @After
    public void destory() {
        transaction.commit(); //提交事务
        session.close(); //关闭会话
        sessionFactory.close(); //关闭会话工厂
    }

    @Test
    public void testSaveStudents() {
        //生成学生对象
        Students s = new Students(1, "张三丰1", "男", new Date(), "武当山");
        session.save(s); //保存对象进入数据库
    }
}
