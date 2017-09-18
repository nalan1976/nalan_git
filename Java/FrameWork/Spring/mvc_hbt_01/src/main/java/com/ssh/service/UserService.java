package com.ssh.service;
import com.ssh.entity.User;
public interface UserService {

    User checkLogin(String name, String pass);

    boolean register(String name, String pass);
}
