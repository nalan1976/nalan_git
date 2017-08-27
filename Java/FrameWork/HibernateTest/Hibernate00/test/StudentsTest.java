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


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

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
        //创建配置对象，加载hibernate.cfg.xml文件
        Configuration config = new Configuration().configure();
//        config.addResource("Students.hbm.xml");
//        Configuration config = new AnnotationConfiguration().configure();
        //创建服务注册对象（好像没有用到）
//        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
//        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
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
        //测试List对象映射
        List schools = new ArrayList();
        schools.add("上海小学");
        schools.add("武当山中学");
        schools.add("MIT");
        s.setSchools(schools);
        session.save(s); //保存对象进入数据库
        System.out.println("@test After session.save()");
//        transaction.commit();//不能在这里调用，为什么？
        System.out.println("@test After transaction.commit()");

    }
}
