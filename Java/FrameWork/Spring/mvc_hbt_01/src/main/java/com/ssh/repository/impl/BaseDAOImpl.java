package com.ssh.repository.impl;


import com.ssh.repository.BaseDAO;
import org.hibernate.Criteria;
import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
//import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Repository
@Scope("prototype")
@SuppressWarnings("unchecked" )
public class BaseDAOImpl<T, ID extends Serializable> implements BaseDAO<T, ID> {

//    @Autowired
//    private HibernateTemplate ht;

    @Autowired
    private SessionFactory sessionFactory;


//    public void setHt(Session ht) {
//        this.ht = ht;
//    }

    private Session getHt() {
//        ht.setCacheQueries(true);
//        ht.getSessionFactory().getCurrentSession().setHibernateFlushMode(FlushMode.AUTO);
        //使用opensession，并在xml中加入thread设置是否可行？
        //使用openSession才行？
//        Session s = sessionFactory.openSession();
        Session s = sessionFactory.getCurrentSession();
        System.out.println(sessionFactory);
        System.out.println(s.hashCode());
        return s;


    }

    @Override
    public boolean add(Object o) {
        try {
            this.getHt().save(o);
            System.out.println("add return ture" );
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(Object o) {
        try {
            this.getHt().delete(o);
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Object o) {
        try {
            this.getHt().update(o);
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

//    @Override
//    public List find(Object o) {
////        if(getHt().f)
////        return this.getHt().findByExample(o);
//    }
    @Override
    public T findById(T o, ID id){
            if (id == Integer.valueOf(0)) return null;
            return (T) this.getHt().load(o.getClass(), id);
    }
    @Transactional
    public List<T> findByProperty(Class entityClass, String propertyName,Object value) {
//        String queryString = "from "+entityClass.getName()+ " as model where model." + propertyName + "=?";
        String queryString = "from "+entityClass.getName()+ " as model where model." + propertyName + " = '"+ value + "'";
//        return getHt().find(queryString, value);
//        getHt().setHibernateFlushMode(FlushMode.AUTO);
        Query qr = getHt().createQuery(queryString);
        if(qr.list().size() != 0) return qr.list();
        return null;
    }

}
