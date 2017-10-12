package com.nalan.mdvr.service;

import com.nalan.mdvr.bean.PassInStruct;
import com.nalan.mdvr.bean.StructUserGroup;
import com.nalan.mdvr.entity.UserGroup;

import java.util.List;

public interface IUserGroupService {
    StructUserGroup addUserGroup(String userGroupName);
    StructUserGroup delUserGroup(List<PassInStruct> ugIdList);
    StructUserGroup chgUserGroup(int userGroupId, String newName);
}
