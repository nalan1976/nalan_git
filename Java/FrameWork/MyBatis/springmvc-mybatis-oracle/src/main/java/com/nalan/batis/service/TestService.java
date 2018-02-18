package com.nalan.batis.service;

import com.nalan.batis.dao.ITest;
import com.nalan.batis.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class TestService implements ITestService{
    @Resource
    private ITest dao;

    @Override
    public void insert(int id, String name, String pswd){
        dao.insertTest(id, name, pswd);
    }
    @Override
    public void insert(String name, String pswd){
        dao.insertTest(name, pswd);
    }
    @Override
    public User selectTest(int id){
        //调用userMapper的方法
        User user = dao.selectTest(id);
        return user;
    }
    public List<User> selectList(int id){
        List<User> userList = dao.selectList(id);
        return userList;
    }
}
