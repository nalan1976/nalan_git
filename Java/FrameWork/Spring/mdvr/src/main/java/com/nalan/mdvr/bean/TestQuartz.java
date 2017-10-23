package com.nalan.mdvr.bean;

import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import java.util.Date;

public class TestQuartz {
    public void TestMethod(){
        System.out.println("Quartz running at : " + new Date());
    }
}
