package com.ssh.web.taglib;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

//控制标签体是否执行
public class HeddinSimpleTag extends SimpleTagSupport {

    @Override
    public void doTag() throws JspException, IOException {
        JspFragment jf=this.getJspBody();//拿到标签体对象
        //下面注释掉就实现了隐藏功能
//        jf.invoke(this.getJspContext().getOut());//控制标签体执行:输出标签体


    }
}