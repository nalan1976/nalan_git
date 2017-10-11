package com.nalan.mdvr.repository.impl;

import com.nalan.mdvr.entity.UserGroup;
import com.nalan.mdvr.repository.IUserGroupDao;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Data
@Repository
//下面这个声明是这个类90%存在的意义！！！
public class UserGroupDao extends BaseDao<UserGroup, Serializable> implements IUserGroupDao<UserGroup, Serializable> {//nalan_*:EntityDao::*;

    public void setUserGroup(UserGroup userGroup) {
        this.userGroup = userGroup;
    }

    public UserGroup getUserGroup() {

        return userGroup;
    }

    public UserGroupDao() {
        this.userGroup = new UserGroup();
    }

    private UserGroup userGroup;

    @Override
    public UserGroup addUserGroup(String userGroupName) {
//        UserGroup userGroup = new UserGroup();
        userGroup.setUserGroupName(userGroupName);
        this.save(userGroup);
        return userGroup;
    }

    public List<UserGroup> findAllByHql() {
        return (List<UserGroup>) findAllByHql(userGroup);
    }
}
