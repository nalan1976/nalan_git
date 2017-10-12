package com.nalan.mdvr.repository.impl;

import com.nalan.mdvr.repository.IBaseDao;
//import lombok.Data;
import org.hibernate.query.Query;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

import org.hibernate.SessionFactory;

import javax.annotation.Resource;

@Repository
@SuppressWarnings({ "rawtypes", "unchecked" })//nalan?
//@Data
public class BaseDao<T, ID extends Serializable> implements IBaseDao<T, ID> {
    @Resource
    private SessionFactory sf;
    protected Class<T> entityClass;

    public void setSf(SessionFactory sf) {
        this.sf = sf;
    }

    public void setEntityClass(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public SessionFactory getSf() {

        return sf;
    }

    public Class<T> getEntityClass() {
        if(entityClass == null){
            Type genType = getClass().getGenericSuperclass();
            Type[] params = ((ParameterizedType)genType).getActualTypeArguments();
            entityClass = (Class)params[0];//nalan? 参数里是什么？为什么取第一个
        }

        return entityClass;
    }

    public BaseDao() {

    }

    @Override
    public void save(T t){
        sf.getCurrentSession().save(t);
    }
    @Override
    public void saveOrUpdate(T t){
        sf.getCurrentSession().saveOrUpdate(t);
    }
    @Override
    public  T load(ID id){
       return sf.getCurrentSession().load(getEntityClass(), id);
    }
    @Override
    public T get(ID id){
        return sf.getCurrentSession().get(getEntityClass(), id);
    }
    @Override
    public boolean contains(T t){
        //用来判断某个实例是否处于当前session的缓存中
        return sf.getCurrentSession().contains(t);
    }
    @Override
    public void delete(T t){
        sf.getCurrentSession().delete(t);
    }
    @Override
    public boolean deleteById(ID id){
        T t = get(id);
        if(t!= null){
            delete(t);
            return true;
        }
        return false;
    }
    @Override
    public void deleteAll(Collection<T> entities){
        for(Object c : entities){
            sf.getCurrentSession().delete(c);
        }
    }
    @Override
    public void refresh(T t){
        sf.getCurrentSession().refresh(t);
    }
    @Override
    public void update(T t){
        sf.getCurrentSession().update(t);
    }
    
    
    @Override
    public void queryHql(String hqlString, Object...values){

    }

/**使用Hql，获得符合条件的唯一对象
 * */
    @Override
    public T getBySql(String sqlString, Object... values){
       Query q = sf.getCurrentSession().createQuery(sqlString);
        if(values != null){
            for(int i=0; i < values.length; i++){
                q.setParameter(i, values[i]);
            }
        }
        return (T)q.uniqueResult();
    }
    /**传入查询实体类型
     * */
    @Override
    public List<T> findAllByHql(T entityClass) {
//        sf.getCurrentSession().flush();
        String queryString = "from " + entityClass.getClass().getSimpleName();
        Query qr = sf.getCurrentSession().createQuery(queryString);
        return qr.list();
/*        List<T> list = qr.list();
        return list;*/

//        if(list.size() != 0)
//            return list;
//        return null;
    }
    @Override
    public void flush(){
        sf.getCurrentSession().flush();
    }
}
