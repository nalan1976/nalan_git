package com.nalan.mdvr.controller;

import com.nalan.mdvr.entity.User;
import org.springframework.util.Assert;

import javax.servlet.http.HttpServletRequest;

import static com.nalan.mdvr.cons.constant.USER_CONTEXT;

/**
 * 所有Controller的基类
 */
public class BaseController {
    protected static final String ERROR_MSG_KEY = "errorMsg";

    /**
     * 获取保存在Session中的用户对象
     *
     * @param request
     * @return
     */
    protected User getSessionUser(HttpServletRequest request) {
        return (User) request.getSession().getAttribute(
                USER_CONTEXT);
    }

    /**
     * 保存用户对象到Session中
     * @param request
     * @param user
     */
    protected void setSessionUser(HttpServletRequest request,User user) {//nalan_*:web:session::*;
        request.getSession().setAttribute(USER_CONTEXT,
                user);
    }


    /**
     * 获取基于应用程序的url绝对路径
     *
     * @param request
     * @param url
     *            以"/"打头的URL地址
     * @return 基于应用程序的url绝对路径
     */
    public final String getAppbaseUrl(HttpServletRequest request, String url) {
        Assert.hasLength(url, "url不能为空");
        Assert.isTrue(url.startsWith("/"), "必须以/打头");
        return request.getContextPath() + url;
    }


}
