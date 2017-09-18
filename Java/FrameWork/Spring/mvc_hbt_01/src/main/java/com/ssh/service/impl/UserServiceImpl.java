package com.ssh.service.impl;

import com.ssh.entity.User;
import com.ssh.repository.BaseDAO;
import com.ssh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Scope("prototype")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private BaseDAO baseDAO;

    @Override
    public User checkLogin(String name, String pass) {

        User u = new User();
        u.setUsername(name);
        u.setPassword(pass);
//        List users = baseDAO.find(u);
//        if (users.size() != 0) return (User)users.get(0);

//        List users = (User) baseDAO.findById(u, 0);
//        if (users.size() != 0) return (User) users.get(0);

        return null;
    }

    @Override
    public boolean register(String name, String pass) {
        System.out.println("register be called");
        User u = new User();
        u.setUsername(name);
        u.setPassword(pass);
//        User users = (User)baseDAO.findById(u, 0);
        List users = baseDAO.findByProperty(u.getClass(), "username", name);
        if (users == null)
            return baseDAO.add(u);
        else {
//        return users.size() == 0 && baseDAO.add(u);
            System.out.println("return false with users:" + users);
            return false;
        }
    }
}
