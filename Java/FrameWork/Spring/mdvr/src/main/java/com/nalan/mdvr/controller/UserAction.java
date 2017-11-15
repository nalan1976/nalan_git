package com.nalan.mdvr.controller;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nalan.mdvr.bean.PassInChange;
import com.nalan.mdvr.bean.PassInStructUser;
import com.nalan.mdvr.bean.StructMenu;
import com.nalan.mdvr.bean.StructUser;
import com.nalan.mdvr.bean.pentaho.Sample4;
import com.nalan.mdvr.bean.pentaho.Sample4Modify;
import com.nalan.mdvr.entity.User;
import com.nalan.mdvr.entity.UserGroup;
import com.nalan.mdvr.entity.UserLog;
import com.nalan.mdvr.repository.impl.UserDao;
import com.nalan.mdvr.service.IUserService;
import com.nalan.mdvr.service.impl.UserService;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static com.nalan.mdvr.cons.constant.LOGIN_TO_URL;
import static com.nalan.mdvr.cons.constant.MENU_USER;

@Data
@EqualsAndHashCode(callSuper=false)
@Controller
@Scope("prototype")
@RequestMapping("/")
public class UserAction extends BaseController{
    @Autowired
    private IUserService userService;

    @RequestMapping("login")
    public String login(@RequestParam(value="username", required = true) String username,//nalan?   required=true没起作用？
                        @RequestParam(value="password", required = true) String password, HttpServletRequest request) {
        User dbUser = userService.checkUser(username, password);
        if (dbUser != null) {
//            User dbUser = new User();
            dbUser.setUserType(dbUser.getUserType());
            setSessionUser(request,dbUser);
            String toUrl = (String)request.getSession().getAttribute(LOGIN_TO_URL);
            request.getSession().removeAttribute(LOGIN_TO_URL);
            //读取并设置登陆用户菜单权限
            StructMenu menu = userService.getMenu();
            request.getSession().setAttribute(MENU_USER, menu);
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
    @RequestMapping("/jsp/setup/delUser")
    public @ResponseBody
    List<User> delUser(@RequestBody Map<String, Integer> userIdInfo){
        return userService.delUser(userIdInfo);
//        return null;
    }
    @RequestMapping("reporting")
    public void generatorReprot(HttpServletRequest request, HttpServletResponse response){
        Sample4Modify sample4Modify = new Sample4Modify();
        sample4Modify.init();
        try {
            sample4Modify.doGet(request, response);
        }catch (Exception e){
            e.printStackTrace();
        }
        sample4Modify.destroy();
    }

}
