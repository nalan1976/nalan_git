package com.nalan.batis.controller;

import com.nalan.batis.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
//@RequestMapping("batis/test/${id}")
@RequestMapping("batis")
public class CtrMain {
    @Autowired
    private ITestService service;

    @RequestMapping("insert")
    public String doInsert(@RequestParam(value="username") String username,
                           @RequestParam(value="password") String password){
//        service.insert(2, username, password);
        service.insert(username, password);
        return "success";
    }

}
