package com.nalan.mdvr2.dao;

import com.nalan.mdvr2.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
//@Component
public interface UserDao {
    //添加用户信息
    int insertUser(User user);
}
