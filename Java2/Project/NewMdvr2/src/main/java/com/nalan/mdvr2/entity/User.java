package com.nalan.mdvr2.entity;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;
//@Component
public class User {
/**
 *     `userId` INT(11) NOT NULL AUTO_INCREMENT,
 `userType` INT(2) NOT NULL COMMENT '0:系统默认超级用户, 1: ',
 `userState` INT(2) NOT NULL COMMENT '0:正常，1：暂停，2：禁用',
 `userName` VARCHAR(255) NOT NULL,
 `password` VARCHAR(255) NOT NULL,
 `createTime` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
 `lastLogin` TIMESTAMP NOT NULL DEFAULT 19700101080001,
 * */
    private Long userId;
    private Integer userType;
    private Integer userState;
    private String password;
    private String userName;
    private Timestamp createTime;
    private Timestamp lastLogin;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Integer getUserState() {
        return userState;
    }

    public void setUserState(Integer userState) {
        this.userState = userState;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Timestamp lastLogin) {
        this.lastLogin = lastLogin;
    }


}
