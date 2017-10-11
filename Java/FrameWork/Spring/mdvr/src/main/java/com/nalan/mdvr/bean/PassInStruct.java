package com.nalan.mdvr.bean;

import java.io.Serializable;
//用于转化输入的json字符串到userGroupId
public class PassInStruct implements Serializable {
    private static final long serialVersionUID = -260498368115167860L;
    private String userGroupId;

    public void setUserGroupId(String userGroupId) {
        this.userGroupId = userGroupId;
    }

    public String getUserGroupId() {

        return userGroupId;
    }

    public PassInStruct() {
        super();
    }
}
