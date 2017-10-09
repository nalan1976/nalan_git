package com.nalan.mdvr.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

}
