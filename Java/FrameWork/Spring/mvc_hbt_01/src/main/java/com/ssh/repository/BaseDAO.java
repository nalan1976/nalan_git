package com.ssh.repository;

import java.io.Serializable;
import java.util.List;

public interface BaseDAO<T, ID extends Serializable> {

    boolean add(Object o);

    boolean delete(Object o);

    boolean update(Object o);

//    List find(Object o);

    T  findById(T o, ID id);
    public List<T> findByProperty(Class entityClass, String propertyName,Object value);
}