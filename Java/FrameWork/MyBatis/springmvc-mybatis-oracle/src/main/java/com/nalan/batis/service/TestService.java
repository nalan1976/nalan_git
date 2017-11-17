package com.nalan.batis.service;

import com.nalan.batis.dao.ITest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

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
}
