package com.nalan.mdvr.repository.impl;

import com.nalan.mdvr.entity.UserGroup;
import com.nalan.mdvr.repository.IUserDao;
import com.nalan.mdvr.repository.IUserGroupDao;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Data
@Repository
public class UserGroupDao<T, ID extends Serializable> extends BaseDao<T, ID> implements IUserGroupDao<T, ID> {
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
    public UserGroup addUserGroup(String userGroupName){
//        UserGroup userGroup = new UserGroup();
        userGroup.setUserGroupName(userGroupName);
        this.save((T)userGroup);
        return userGroup;
    }
    public List<UserGroup> findAllByHql(){
        return (List<UserGroup>)findAllByHql((T)userGroup);
    }
}
