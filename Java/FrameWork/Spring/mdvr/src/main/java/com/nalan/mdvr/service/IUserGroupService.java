package com.nalan.mdvr.service;

import com.nalan.mdvr.bean.PassInStruct;
import com.nalan.mdvr.bean.StructUser2Group;
import com.nalan.mdvr.bean.StructUserGroup;
import com.nalan.mdvr.entity.User;
import com.nalan.mdvr.entity.UserGroup;

import java.util.List;
import java.util.Map;

public interface IUserGroupService {
    StructUserGroup addUserGroup(String userGroupName);
    StructUserGroup delUserGroup(List<PassInStruct> ugIdList);
    StructUserGroup chgUserGroup(int userGroupId, String newName);
    StructUser2Group addUser2Group(Map<String, Integer> mapInfo);
    List<User> showUserGroup(Integer userGroupId);

}
