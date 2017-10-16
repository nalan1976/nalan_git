package com.nalan.mdvr.controller;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nalan.mdvr.bean.PassInChange;
import com.nalan.mdvr.bean.PassInStructUser;
import com.nalan.mdvr.bean.StructUser;
import com.nalan.mdvr.entity.User;
import com.nalan.mdvr.entity.UserGroup;
import com.nalan.mdvr.entity.UserLog;
import com.nalan.mdvr.repository.impl.UserDao;
import com.nalan.mdvr.service.IUserService;
import com.nalan.mdvr.service.impl.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;

@Data
@Controller
@Scope("prototype")
@RequestMapping("/")
public class UserAction {
    @Autowired
    private IUserService userService;

    @RequestMapping("login")
    public String login(@RequestParam(value="username", required = true) String username,//nalan?   required=true没起作用？
                        @RequestParam(value="password", required = true) String password) {
        if (userService.checkUser(username, password)) {
            return "setup/userGroup";
        }
        return "error";
    }
    @RequestMapping("/jsp/setup/addUser")
    public @ResponseBody
    StructUser addUser(@RequestBody String userInfo){
        //将获得的json字符串转化为对象list
        PassInStructUser passInStructUser = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            passInStructUser = objectMapper.readValue(userInfo, PassInStructUser.class);//nalan_*:json:convert:*;   转化非list的json对象
        }catch(Exception e){
            e.printStackTrace();
        }
//        return userService.addUser(structUser);
        return userService.addUser(passInStructUser.getUserName(), passInStructUser.getUserType(), passInStructUser.getPassword());
//        return null;
    }


}
