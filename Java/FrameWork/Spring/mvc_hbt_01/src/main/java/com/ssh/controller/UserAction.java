package com.ssh.controller;


import com.ssh.entity.User;
import com.ssh.service.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.apache.commons.lang.StringUtils;


@Data
@Controller
@Scope("prototype")
//@RequestMapping("/views/")
public class UserAction {
    //log4j
    static final Logger lg = LogManager.getLogger(UserAction.class);

    @Autowired
    private UserService userService;

    private String username;
    private String password;

    @RequestMapping("/views/login.do")
//    @RequestMapping("/views/login")
//    @ResponseBody
    public  String dispatch(String username, String password, String action_log){
        String s[] = System.getProperty("java.class.path").split(";");
        for (String string : s) {
            System.out.println(string);
        }
        System.out.println(getWEB_INF().replace("WEB-INF/", ""));

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
//        System.out.println("register() b is :" + b);
        lg.trace("register() b is :" + b);

        if (b)
            return "loginSuccess";
        else
            return "loginError";
    }
    public static String getWEB_INF(){
        return getClassPath().replace("classes/", "");
    }
    /**
     * 获取到classes目录
     * @return path
     */
    public static String getClassPath(){
        String systemName = System.getProperty("os.name");

        //判断当前环境，如果是Windows 要截取路径的第一个 '/'
        if(!StringUtils.isBlank(systemName) && systemName.indexOf("Windows") !=-1){
            return UserAction.class.getResource("/").getFile().toString().substring(1);
        }else{
            return UserAction.class.getResource("/").getFile().toString();
        }
    }
}