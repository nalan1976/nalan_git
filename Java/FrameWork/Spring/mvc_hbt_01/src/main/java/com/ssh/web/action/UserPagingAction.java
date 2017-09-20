package com.ssh.web.action;


import com.ssh.bean.Page;
import com.ssh.repository.UserDao;
import com.ssh.util.WebUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@Controller //("/listBook")  //注意这个注解，它的作用是将这个action交给Spring管理，实现SSH集成
@Scope("prototype")
public class UserPagingAction {
    //注入一个userDao数据访问组件
    @Resource
    UserDao userDao;

    @Autowired
    private HttpServletRequest request;
//    @Autowired
//    private HttpServletResponse response;

    //"/views/jsp/paging.do"
    @RequestMapping("/views/jsp/paging.do")
    public ModelAndView dispatch(String currentPage, String next, String action_log) {
        //从request对象里得到页码信息，如果为空或不是数值都返回1
        int pageindex = WebUtil.getIntByRequestParament(request, "pageindex", 1);
        //构造一个page对象，第1个参数是当前页，第2个参数是该页最大记录数，第3个是页码上的连接地址
        Page page = new Page(pageindex, 20, "paging.do");
        //将page对象送到数据访问组件层，返回当前页的数据借助request作用域送到视图层，
        //当然也可以封装到page对象里
        List list = userDao.listAllUserPagings(page);
        request.setAttribute("users", list);//nalan books要改掉
        //出来后的page对象已经有了总记录数了，自然就有了页码信息
        request.setAttribute("page", page);
        return new ModelAndView("forward:user.jsp", "users", list);
    }
/*localhost:8080/views/jsp/user.jsp

    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response)
            throws Exception {
//从request对象里得到页码信息，如果为空或不是数值都返回1
        int pageindex = WebUtil.getIntByRequestParament(request, "pageindex", 1);
//构造一个page对象，第1个参数是当前页，第2个参数是该页最大记录数，第3个是页码上的连接地址
        Page page = new Page(pageindex, 20, "listBook.do");
//将page对象送到数据访问组件层，返回当前页的数据借助request作用域送到视图层，
//当然也可以封装到page对象里
        request.setAttribute("books", bookDao.listAllBooks(page));//nalan books要改掉
//出来后的page对象已经有了总记录数了，自然就有了页码信息
        request.setAttribute("page", page);
        return mapping.findForward("list");
    }*/
}