package com.ssh.repository.impl;


import com.ssh.bean.Page;
import com.ssh.entity.UserPaging;
import com.ssh.repository.UserDao;


import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Repository //交给Spring管理
@Transactional          //声明Spring管理事务
public class UserDaoImpl implements UserDao {
    //在Spring容器里取得Hibernate的session工厂对象
    @Resource
    protected SessionFactory sessionFactory;

    public void save(UserPaging user) {
        sessionFactory.getCurrentSession().persist(user);
    }

    public void update(UserPaging user) {
        sessionFactory.getCurrentSession().merge(user);
    }

    public void delete(UserPaging user) {
        sessionFactory.getCurrentSession().delete(user);
    }

    public UserPaging getUserPaging(Integer id) {
        return (UserPaging) sessionFactory.getCurrentSession().get(UserPaging.class, id);
    }

    //数据分页
    @SuppressWarnings("unchecked")
    public List listAllUserPagings(Page page) {
        Query query = sessionFactory.getCurrentSession().createQuery("select count(*) from UserPaging");
//得到总记录并保存到page对象中
        long l = (Long) query.uniqueResult();
        page.setTotalCount((int) l);
        query = sessionFactory.getCurrentSession().createQuery("from UserPaging");
//注意下面这个分页参数
        query.setFirstResult(page.getFirstIndex()).setMaxResults(page.getPageSize()).setFetchSize(page.getPageSize());
//        query.setFirstResult(page.getFirst()).setMaxResults(page.getPageSize()).setFetchSize(page.getPageSize());//nalan
        return query.list();
    }
}
