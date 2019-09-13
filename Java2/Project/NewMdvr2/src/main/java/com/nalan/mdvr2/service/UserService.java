package com.nalan.mdvr2.service;

import com.nalan.mdvr2.entity.User;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    int insertUser(User user);
}
