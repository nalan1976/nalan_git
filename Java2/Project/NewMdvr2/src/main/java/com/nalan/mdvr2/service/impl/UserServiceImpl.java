package com.nalan.mdvr2.service.impl;

import com.nalan.mdvr2.dao.UserDao;
import com.nalan.mdvr2.entity.User;
import com.nalan.mdvr2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;

    @Override
    public int insertUser(User user) {
        return userDao.insertUser(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        UserDetails userDetails  = null;

        return new org.springframework.security.core.userdetails.User(username, "1234"
                , true, true, true, true
                , AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}
