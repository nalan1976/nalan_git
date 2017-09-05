package com.nalan.util.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.HibernateException;
//import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyComponentPathImpl;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory sessionFactory ;
//    private static final SessionFactory sessionFactory;
    static {
        //for Hibernate 4.x
//        try {
//            // Create the SessionFactory from hibernate.cfg.xml
//            sessionFactory = new Configuration().configure().buildSessionFactory();
//        } catch (Throwable ex) {
//            // Make sure you log the exception, as it might be swallowed
//            System.err.println("初始化SessionFactory失败！" + ex);
//            throw new ExceptionInInitializerError(ex);
//        }
        try {
            //for Hibernate 5.x
            StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().configure().build();
            Metadata metadata = new MetadataSources(standardRegistry).getMetadataBuilder().applyImplicitNamingStrategy(ImplicitNamingStrategyComponentPathImpl.INSTANCE).build();
            sessionFactory = metadata.getSessionFactoryBuilder().build();
        }catch(Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("初始化SessionFactory失败！" + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    public static final ThreadLocal session = new ThreadLocal();
    public static Session getCurrentSession() throws HibernateException {
        Session s = (Session) session.get();
        //当原Session为空或已关闭时，打开一个新的Session
        if ((s == null || !s.isOpen()) & (session != null)) {
            s = sessionFactory.openSession();
            session.set(s);
        }
        return s;
    }
    public static void close(){
        if(sessionFactory != null)
            sessionFactory.close();
    }
    //session还是需要关闭的
    public static void closeSession() throws HibernateException {
        Session s = (Session) session.get();
        session.set(null);
        if (s != null) {
            s.close();
        }
    }
}
