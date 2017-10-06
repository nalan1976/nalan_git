package com.nalan.mdvr.service.impl;

import com.nalan.mdvr.repository.IUserDao;
import com.nalan.mdvr.entity.User;
//import com.nalan.mdvr.repository.impl.BaseDao;
//import com.nalan.mdvr.repository.impl.UserDao;
import com.nalan.mdvr.service.IUserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Data
@Service
@Scope("prototype")
@Transactional
public class UserService implements IUserService {
    @Autowired
    private IUserDao userDao;
    @Override
    public boolean checkUser(String username, String password){
        User user = new User();
        user.setUserName(username);
        user.setPassword(password);
//        return userDao.hasUser(user);
        return userDao.checkLoginInfo(user);
    }
}
