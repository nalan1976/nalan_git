package com.nalan.mdvr.service;

import com.nalan.mdvr.bean.StructUser;

public interface IUserService {
    boolean checkUser(String username, String password);
    StructUser addUser(String userName, int userType, String pswd);
//    StructUser addUser(StructUser userStruct);
}
