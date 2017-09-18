package com.ssh.controller;


import com.ssh.entity.User;
import com.ssh.service.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Data
@Controller
@Scope("prototype")
//@RequestMapping("/views/")
public class UserAction {

    @Autowired
    private UserService userService;

    private String username;
    private String password;

    @RequestMapping("/views/login.do")
//    @RequestMapping("/views/login")
//    @ResponseBody
    public  String dispatch(String username, String password, String action_log){
        if(username == null || password == null)
            return "loginError";
        else{
            this.password = password;
            this.username = username;
        }

        if(action_log.equals("登陆"))
            return login(username, password);
        else
            return register();

    }

    public String login(String username, String password) {
        User user = userService.checkLogin(username, password);
        if (user != null) return "loginSuccess";
        return "loginError";
    }


    public String register() {
        boolean b = userService.register(username, password);
        System.out.println("register() b is :" + b);
        if (b)
            return "loginSuccess";
        else
            return "loginError";
    }

}