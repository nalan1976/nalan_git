package com.nalan.batis.dao;

import org.apache.ibatis.annotations.Param;

public interface ITest {
    void insertTest(@Param("id") int id, @Param("username") String username, @Param("password") String password);
    void insertTest(/*@Param("id") int id,*/ @Param("username") String username, @Param("password") String password);
}
