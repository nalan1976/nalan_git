package com.nalan.mdvr.controller;

import com.nalan.mdvr.bean.StructMenu;
import com.nalan.mdvr.bean.StructUser;
import com.nalan.mdvr.entity.User;
import org.apache.commons.lang.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import static com.nalan.mdvr.cons.constant.*;
//import javax.servlet.annotation.WebFilter;
/**filter的作用是在访问任何页面时，若没有权限则返回登录页面
 * 目前这个项目实际上用不到这个filter，不要向web.xml注册即可
 * */
//@WebFilter(urlPatterns = {"/*"})
public class MyFilter implements Filter {
    private static final String FILTERED_REQUEST = "@@session_context_filtered_request";//nalan???  为何要这么写，@@是什么意思？
    // ① 不需要登录即可访问的URI资源
    private static final String[] INHERENT_ESCAPE_URIS = { "/index.html", "/login.jsp", "/login/doLogin.html",
            "/register.jsp", "/register.html", "/board/listBoardTopics-",
            "/board/listTopicPosts-" };


    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        // ②-1 保证该过滤器在一次请求中只被调用一次
        if (request != null && request.getAttribute(FILTERED_REQUEST) != null) {
            chain.doFilter(request, response);
        } else {

            // ②-2 设置过滤标识，防止一次请求多次过滤
            request.setAttribute(FILTERED_REQUEST, Boolean.TRUE);
            HttpServletRequest httpRequest = (HttpServletRequest) request;
            User userContext = getSessionUser(httpRequest);
            //测试menu
            StructMenu menu = (StructMenu)httpRequest.getSession().getAttribute(MENU_USER);
            request.getRequestDispatcher("/").forward(request,
                    response);
            //测试end

            // ②-3 用户未登录, 且当前URI资源需要登录才能访问
            if (userContext == null
                    && !isURILogin(httpRequest.getRequestURI(), httpRequest)) {
                String toUrl = httpRequest.getRequestURL().toString();
                if (!StringUtils.isEmpty(httpRequest.getQueryString())) {
                    toUrl += "?" + httpRequest.getQueryString();
                }

//                 ②-4将用户的请求URL保存在session中，用于登录成功之后，跳到目标URL
                httpRequest.getSession().setAttribute(LOGIN_TO_URL, toUrl);

//                 ②-5转发到登录页面
                request.getRequestDispatcher("/index.jsp").forward(request,
                        response);
                return;
            }
            chain.doFilter(request, response);
        }
    }
    public void init(FilterConfig filterConfig) throws ServletException {
    }
    /**
     * 当前URI资源是否需要登录才能访问
     * @param requestURI
     * @param request
     * @return
     */
    private boolean isURILogin(String requestURI, HttpServletRequest request) {
        if (request.getContextPath().equalsIgnoreCase(requestURI)
                || (request.getContextPath() + "/").equalsIgnoreCase(requestURI))
            return true;
        for (String uri : INHERENT_ESCAPE_URIS) {
            if (requestURI != null && requestURI.indexOf(uri) >= 0) {
                return true;
            }
        }
        return false;
    }

    protected User getSessionUser(HttpServletRequest request) {
        return (User) request.getSession().getAttribute(USER_CONTEXT);
    }

    public void destroy() {
    }

}
