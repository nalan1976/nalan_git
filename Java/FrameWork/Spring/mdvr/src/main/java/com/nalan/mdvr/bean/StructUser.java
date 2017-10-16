package com.nalan.mdvr.bean;

import com.nalan.mdvr.entity.User;

import java.util.Date;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class StructUser implements Serializable {
    class InnerUser {
        private Integer userId;
        private String userName;
        private Integer userType = 0;
        private Date createDatetime;

//自动生成
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

        public void setCreateDatetime(Date createDatetime) {
            this.createDatetime = createDatetime;
        }

        public Date getCreateDatetime() {

            return createDatetime;
        }
//自动生成end
    }

    //一个User对象
    private User user;
    //一个InnerUser的list
    public List<InnerUser> innerUserList;

    //一个空构造创建InnerUser数组
    public StructUser() {
        innerUserList = new ArrayList<>();
    }
    //填充innerUserList，用于返回前台的数据
    public void setUserInfo(int id, String name, int type, Date createDatetime) {
        InnerUser iu = new InnerUser();
        iu.userId = id;
        iu.userName = name;
        iu.userType = type;
        iu.createDatetime = createDatetime;
        innerUserList.add(iu);
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setInnerUserList(List<InnerUser> innerUserList) {
        this.innerUserList = innerUserList;
    }

    public User getUser() {
        return user;
    }

    public List<InnerUser> getInnerUserList() {
        return innerUserList;
    }
}

