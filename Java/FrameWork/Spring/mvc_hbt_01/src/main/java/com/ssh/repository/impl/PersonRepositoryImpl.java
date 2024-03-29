package com.ssh.repository.impl;

import com.ssh.repository.PersonRepository;
import com.ssh.entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class PersonRepositoryImpl implements PersonRepository {

    //注入的sessionFactory是从哪里来的？根据类型自动注入session工厂
    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        Session s = this.sessionFactory.openSession();
        System.out.println(s.hashCode());
        System.out.println(sessionFactory);
        return s;
//        return this.sessionFactory.openSession();
    }

    public Person load(Long id) {
        return (Person)getCurrentSession().load(Person.class,id);
    }

    public Person get(Long id) {
        return (Person)getCurrentSession().get(Person.class,id);
    }

    public List<Person> findAll() {
        return null;
    }

    public void persist(Person entity) {
        getCurrentSession().persist(entity);
    }

    public Long save(Person entity) {
        return (Long)getCurrentSession().save(entity);
    }

    public void saveOrUpdate(Person entity) {
        getCurrentSession().saveOrUpdate(entity);
    }

    public void delete(Long id) {
        Person person = load(id);
        getCurrentSession().delete(person);
    }

    public void flush() {
        getCurrentSession().flush();
    }

    public void findByProperty(Class entityClass, String propertyName,Object value) {
        String queryString = "from "+entityClass.getName()+ " as model where model." + propertyName + " = '"+ value+"'";
        Query qr = getCurrentSession().createQuery(queryString);
        qr.list();
//        return null;
    }
}