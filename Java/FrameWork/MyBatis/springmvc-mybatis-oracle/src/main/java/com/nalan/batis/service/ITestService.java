package com.nalan.batis.service;

import com.nalan.batis.entity.User;

import java.util.List;

public interface ITestService {
    void insert(int id, String name, String pswd);
    void insert(String name, String pswd);
    User selectTest(int id);
    List<User> selectList(int id);
}
