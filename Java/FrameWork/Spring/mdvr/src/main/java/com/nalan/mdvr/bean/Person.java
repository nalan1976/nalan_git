package com.nalan.mdvr.bean;

import java.io.Serializable;
//用于测试json，项目中没有用到
public class Person implements Serializable{
    private String username;
    private String passwd;

    public String getUsername() {
        return username;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public Person(){
        super();
    }
}
