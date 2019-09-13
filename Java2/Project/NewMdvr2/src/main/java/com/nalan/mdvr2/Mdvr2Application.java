package com.nalan.mdvr2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

import javax.security.auth.login.Configuration;

@SpringBootApplication
//看到的请求处理过程中出现的任何错误
//@EnableAutoConfiguration(exclude=ErrorMvcAutoConfiguration.class)
//排除SrpingSecurity组件的自动配置，使之无效
//@EnableAutoConfiguration(exclude = {
//		org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class
//})
//@MapperScan("com.nalan.mdvr2.dao") //添加扫描mapper
public class Mdvr2Application {

	public static void main(String[] args) {
		SpringApplication.run(Mdvr2Application.class, args);
	}

/*	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/login").setViewName("login");
	}*/
}