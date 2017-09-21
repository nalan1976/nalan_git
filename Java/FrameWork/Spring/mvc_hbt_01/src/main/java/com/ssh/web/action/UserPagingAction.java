package com.ssh.web.action;


import com.ssh.bean.Page;
import com.ssh.repository.UserDao;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
@Scope("prototype")
public class UserPagingAction {
    //注入一个userDao数据访问组件
    @Resource
    UserDao userDao;

//    @Autowired
//    private HttpServletRequest request;


    @RequestMapping("/views/jsp/paging.do")
    public ModelAndView dispatch(HttpServletRequest request/*@RequestParam("pageIndex") String pgIdx */) {
        //从request对象里得到页码信息，如果为空或不是数值都返回1
        String pageindexTemp = request.getParameter("pageIndex");
//     pageindexTemp = pgIdx;

        //若pageIndex为空或非法值，都跳到第一页
        int pageindex = 1;
        try {
            pageindex = Integer.parseInt(pageindexTemp);
        } catch (Exception e) {
        }

        //构造一个page对象，第1个参数是当前页，第2个参数是该页最大记录数，第3个是页码上的连接地址
        Page page = new Page(pageindex, 3, "paging.do");
        //将page对象送到数据访问组件层，返回当前页的数据借助request作用域送到视图层，当然也可以封装到page对象里
        List list = userDao.listAllUserPagings(page);
        request.setAttribute("users", list);//nalan books要改掉
        //出来后的page对象已经有了总记录数了，自然就有了页码信息
        request.setAttribute("page", page);
        return new ModelAndView("forward:user.jsp", "users", list);
    }
/**
 * 访问地址：localhost:8080/views/jsp/user.jsp
 */
}