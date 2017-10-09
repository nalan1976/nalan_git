package com.nalan.mdvr.controller;

import com.nalan.mdvr.bean.StructUserGroup;
import com.nalan.mdvr.entity.UserGroup;
import com.nalan.mdvr.service.IUserGroupService;
import com.nalan.mdvr.service.impl.UserGroupService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
//@Data
@Controller
@Scope("prototype")
@RequestMapping("/jsp/setup")//nalan?    jsp/setup
public class UserGroupAction {
    @Autowired
    private IUserGroupService userGroupService;

    public void setUserGroupService(IUserGroupService userGroupService) {
        this.userGroupService = userGroupService;
    }

    public IUserGroupService getUserGroupService() {

        return userGroupService;
    }

    /**
     * 返回JSON数据
     */
    @RequestMapping("addUserGroup")
    //nalan_*:json:map:*;
    public @ResponseBody
    StructUserGroup addUserGroup(String userGroupName){
//        return null;
        return userGroupService.addUserGroup(userGroupName);

    }
}
