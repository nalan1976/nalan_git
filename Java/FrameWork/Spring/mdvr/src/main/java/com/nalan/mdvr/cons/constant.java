package com.nalan.mdvr.cons;

public interface constant {
    public static final String USER_CONTEXT = "USER_CONTEXT";
    public static final String LOGIN_TO_URL = "toUrl";
    public static final String MENU_USER = "MENU_USER";
    //0为普通用户，1为admin
    enum userType{NORMAL, ADMIN}
    enum userGroup{}

}
