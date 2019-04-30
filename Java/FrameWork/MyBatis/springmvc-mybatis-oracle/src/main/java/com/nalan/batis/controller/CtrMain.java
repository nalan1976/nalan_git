package com.nalan.batis.controller;

import com.nalan.batis.entity.User;
import com.nalan.batis.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

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
    @RequestMapping("selectResult")
    public User selectTest(int id){
        return service.selectTest(id);
    }

    @RequestMapping("selectList")
    public void selectList(int id){
        service.selectList(id);
    }
    @RequestMapping("/upload_file")
    public String upload(@RequestParam(value="upLoadFile", required = false) MultipartFile file, HttpServletRequest request, HttpSession session) {
        //文件在服务器上存储的位置
        String path = request.getSession().getServletContext().getRealPath("/WEB-INF/jsp");//nalan?   tomcat应该放在发布目录/upload/下没有实现

        String originFileName =  file.getOriginalFilename();                        //获取原始文件的名字
        System.out.println(originFileName);                                         //上传文件的名字

        String type = originFileName.substring(originFileName.lastIndexOf(".")+1);  //获取文件的类型,以最后一个"."标识的文件类型作为标准
        System.out.println(type);

        String fileName = System.currentTimeMillis() + "." + type;                  //设置新文件的名字
        File targetFile = new File(path, fileName);                                 //在指定路径创建一个文件

        try {
            file.transferTo(targetFile);                                            //将文件保存到服务器上指定的路径上
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/notice/queryNotice";          //重定向到一个controller//nalan 为了防止重复点击？
        // return "redirect:yannan/notice/noticeList";      //重定向到一个页面
    }
}
