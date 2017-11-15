package com.nalan.mdvr.service;

import com.nalan.mdvr.bean.StructMenu;
import com.nalan.mdvr.bean.StructUser;
import com.nalan.mdvr.entity.User;

import java.util.List;
import java.util.Map;

public interface IUserService {
    User checkUser(String username, String password);
    StructUser addUser(String userName, int userType, String pswd);
//    StructUser addUser(StructUser userStruct);
    List<User> delUser(Map<String, Integer> userIdInfo);
    StructMenu getMenu();
}
