package com.nalan.mdvr.repository;

import com.nalan.mdvr.bean.StructUser;
import com.nalan.mdvr.entity.User;

import java.io.Serializable;

//public interface IUserDao/*<T, ID extends Serializable>*/extends IBaseDao/*<T, ID>*/ {
public interface IUserDao<T, ID extends Serializable>extends IBaseDao<T, ID> {
    boolean hasUser(T t);
//    boolean hasUser(User t);
    boolean checkLoginInfo(User user);

}
