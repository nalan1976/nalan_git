package com.nalan.mdvr.bean;

import com.nalan.mdvr.entity.User;

import java.io.Serializable;
import java.util.List;

//用于转化输入的json字符串到userGroupId
public class PassInStructUser implements Serializable {
/*    List<User> userList;

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public List<User> getUserList() {

        return userList;
    }*/
        private Integer userId;
    private String userName;
    private Integer userType = 0;
    private String password;

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {

        return password;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Integer getUserId() {

        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public Integer getUserType() {
        return userType;
    }

    public PassInStructUser() {
        super();
    }
}
