package com.nalan.mdvr2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 配置默认页面
 * */
@Controller()
@RequestMapping("/")
public class DefaultController {
    @RequestMapping(value={"/", "login"})
    public String index(){
        return "login";
//        return "forward:/default.html";
    }
    @RequestMapping(value={"/error/logError"})
    public String logError(){
        //下面两种写法都ok
        return "/error/logError";
//        return "error/logError";

        //仍可以使用forward方法跳转到普通html页面
//        return "forward:/default.html";
    }

}
