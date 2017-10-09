package com.nalan.mdvr.repository;

import com.nalan.mdvr.bean.StructUserGroup;
import com.nalan.mdvr.entity.UserGroup;

import java.io.Serializable;
import java.util.List;

public interface IUserGroupDao<T, ID extends Serializable>extends IBaseDao<T, ID> {
    UserGroup addUserGroup(String userGroupName);
    List<UserGroup> findAllByHql();
}
