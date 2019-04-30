package com.nalan.batis.dao;

import com.nalan.batis.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ITest {
    void insertTest(@Param("id") int id, @Param("username") String username, @Param("password") String password);
    void insertTest(/*@Param("id") int id,*/ @Param("username") String username, @Param("password") String password);
    User selectTest(@Param("id") int id);
    List<User> selectList(@Param("id") int id);
}
