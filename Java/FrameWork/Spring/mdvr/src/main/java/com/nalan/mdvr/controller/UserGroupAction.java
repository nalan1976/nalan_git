package com.nalan.mdvr.controller;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nalan.mdvr.bean.PassInChange;
import com.nalan.mdvr.bean.PassInStruct;
import com.nalan.mdvr.bean.Person;
import com.nalan.mdvr.bean.StructUserGroup;
import com.nalan.mdvr.entity.UserGroup;
import com.nalan.mdvr.service.IUserGroupService;
import com.nalan.mdvr.service.impl.UserGroupService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    //nalan_*:json:convert:*;
    public @ResponseBody
    StructUserGroup addUserGroup(String userGroupName){
//        return null;
        return userGroupService.addUserGroup(userGroupName);

    }

    @RequestMapping("addUserGroup2")/*value = "addUserGroup2", method = RequestMethod.POST, consumes = "application/json"*/
    public @ResponseBody
    StructUserGroup delUserGroup(HttpServletRequest request, @RequestBody String  ugInfo/*@RequestBody PassInStruct ugInfo*/){/*HashMap<String, Integer>*/

        //将获得的json字符串转化为对象list
        ObjectMapper objectMapper = new ObjectMapper();//nalan_*:json:convert:*;
        JavaType javaType = objectMapper.getTypeFactory().constructParametricType(List.class, PassInStruct.class);
        List<PassInStruct> list = null;
        try{list = objectMapper.readValue(ugInfo, javaType);}
        catch (IOException e){}

        //删除list中主键所表示的数据，并返回userGroup表中剩余数据
        return userGroupService.delUserGroup(list);
//        return null;
    }

    @RequestMapping("changeUserGroup")
    public @ResponseBody
    StructUserGroup changeUserGroup(@RequestBody String ugInfo) {
        //将获得的json字符串转化为对象list
        ObjectMapper objectMapper = new ObjectMapper();
        JavaType javaType = objectMapper.getTypeFactory().constructParametricType(List.class, PassInChange.class);
        List<PassInChange> list = null;
        try{list = objectMapper.readValue(ugInfo, javaType);}
        catch (IOException e){}

        //实在是挺费劲的，先不折腾了！实现的极为别扭
        if(list.size() != 0)
            return userGroupService.chgUserGroup(list.get(0).getUserGroupId(), list.get(1).getNewName());
        else
            return null;
    }
}
