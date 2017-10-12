package com.nalan.mdvr.bean;

import java.io.Serializable;

public class PassInChange implements Serializable{
    private Integer userGroupId;
    private String newName;

    public void setUserGroupId(Integer userGroupId) {
        this.userGroupId = userGroupId;
    }

    public Integer getUserGroupId() {

        return userGroupId;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }



    public String getNewName() {
        return newName;
    }
}
