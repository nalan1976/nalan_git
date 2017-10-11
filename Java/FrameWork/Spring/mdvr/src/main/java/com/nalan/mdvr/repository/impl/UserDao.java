package com.nalan.mdvr.repository.impl;

import com.nalan.mdvr.entity.User;
import com.nalan.mdvr.repository.IUserDao;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Data
@Repository

public class UserDao extends BaseDao<User, Serializable> implements IUserDao<User, Serializable> {//nalan_*:demo:Dao:*;
    //下面这2个声明代表了不同的认知
    // public class UserDao<T, ID extends Serializable> extends BaseDao<T, ID> implements IUserDao<T, ID> {
//public class UserDao extends BaseDao implements IUserDao{
    private static final String STR_QUERY_USER = "FROM User  u where userName"+"=?";
    @Override
    public boolean hasUser(User user){
        return (getBySql(STR_QUERY_USER, (user.getUserName())) != null);
    }

    @Override
    public boolean checkLoginInfo(User user){
        User u = (User)(getBySql(STR_QUERY_USER, user.getUserName()));
        if(u != null && u.getPassword().equals(user.getPassword()))
        {
            return true;
        }
        return false;
    }

}
