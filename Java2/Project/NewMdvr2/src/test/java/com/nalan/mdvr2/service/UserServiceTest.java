package com.nalan.mdvr2.service;

import com.nalan.mdvr2.dao.UserDao;
import com.nalan.mdvr2.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;

//    @Autowired
//    private UserDao userDao;

    @Test
    public void test(){
        User user = new User();
        user.setUserName("testService");
        user.setPassword("1234");
        user.setUserState(0);
        user.setUserType(0);
        user.setCreateTime(Timestamp.valueOf(LocalDateTime.now()));
        user.setLastLogin(Timestamp.valueOf(LocalDateTime.now()));
        Assert.assertEquals(1,userService.insertUser(user));
    }
}
