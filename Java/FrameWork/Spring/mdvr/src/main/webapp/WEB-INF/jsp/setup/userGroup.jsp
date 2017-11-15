<%@ page import="static com.nalan.mdvr.cons.constant.MENU_USER" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/10/6 0006
  Time: 下午 14:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="/css/main.css" rel="stylesheet" type="text/css"/>
    <title>用户组设置</title>
    <%--<%System.out.println(request.getRealPath("/"));%>--%>
    <script src="/js/jquery-3.2.1.js"></script>
    <script type="text/javascript" src="/js/userGroup/userGroup.js"></script>
    <script language="JavaScript">
        function addUserGroup(tblId){/*nalan?   为什么传过来的参数没法用？*/
            var tbl = document.getElementById(tblId);/*这里不能用任何引号*/
            var trObject = document.createElement('tr');
            var td1 = document.createElement('td');
//            var p1 = document.createElement('p');
            var input = document.createElement('input');

            input.setAttribute("class", "checkbox_normal");
            input.setAttribute("type", "checkbox");
//            p1.appendChild(input);
            td1.appendChild(input);
            td1.innerHTML = "测试";/*nalan? input和这里的文字不能同时支持？*/
//            td1.appendChild(p1);
//            p1.appendChild(td1);
//            trObject.appendChild(p1);

            trObject.appendChild(td1);
            tbl.appendChild(trObject);

//            td2.innerHTML = '<a href="' + dict[key] + '">' + key + '</a>';
//            document.write("<lable>hello</lable>");
//            tbl.write("<lable>hello</lable>");
        }
    </script>
</head>
<body>
<div id="div_container">
    <div id="div_menu_header">
        <!-- -------菜单html代码---------begin------- -->
        <div class="menuDiv">
            <ul>
                <li>
                    <a href="#">系统设置</a>
                    <ul>
                        <li><a href="#">用户组管理</a></li>
                        <li><a href="#">用户管理</a></li>
                        <li><a href="#">设备管理</a></li>
                        <li><a href="#">服务器配置</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#">报表</a>
                    <ul>
                        <li><a href="#">二级菜单</a></li>
                        <li><a href="#">二级菜单</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#">菜单三</a>
                    <ul>
                        <li><a href="#">二级菜单</a></li>
                        <li><a href="#">二级菜单</a></li>
                        <li><a href="#">二级菜单</a></li>
                        <li><a href="#">二级菜单</a></li>
                        <li><a href="#">二级菜单</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#">菜单四</a>
                </li>
                <li>
                    <a href="#">菜单五</a>
                    <ul>
                        <li><a href="#">二级菜单</a></li>
                        <li><a href="#">二级菜单</a></li>
                        <li><a href="#">二级菜单</a></li>
                    </ul>
                </li>
            </ul>
        </div><!--menu_div-->
        <!-- -------菜单html代码---------end------- -->
    </div><!--div_menu_header-->
    <div id="div_main">
        <div id="div_user_group"><!--左边主体区域-->
            <div class="div_search">
                <form id="form_search" action="" method="post">
                    <label class="label_normal">用户组</label>
                    <input class="input_text_normal" type="text">
                    <button class="button_normal" type="submit">根据名称搜索</button>
                </form>
            </div>
            <div class="div_table">
                <form id="form_user_group" action="/jsp/setup/addUserGroup" method="post">
                    <table id="table_user_group" border="2">
                        <p>
                            <tr id="tr_title">
                                <p>
                                    <td><input class="checkbox_normal" type="checkbox"></input>用户组ID</td>
                                    <td>用户组名</td>
                                    <td>用户数</td>
                                    <td>权限</td>
                                    <td class="td_hidden" hidden="hidden"></td>
                                </p>
                            </tr>
                            <tr>
                                <p>
                                    <td><input class="checkbox_normal" type="checkbox"></input>temp</td>
                                    <td>temp</td>
                                    <td>temp</td>
                                    <td>temp</td>
                                    <td class="td_hidden" hidden="hidden"></td>
                                </p>
                            </tr>
                        </p>
                    </table>
                </form>
            </div>
            <div class="div_button">
                <!--函数传入时，一定要用单引号。用双引号程序运行错误但不提示任何信息，不加引号传入对象-->
                <input class="input_button_normal" id="btn_add" type="button" value="增加"/> <!--onclick="addUserGroup('table_user_group')"-->
                <input class="input_button_normal" id="btn_delete" type="button" value="删除"/>
                <input class="input_button_normal" id="btn_change" type="button" value="修改"/>
                <input class="input_button_normal" id="btn_test" <%--name="userGroupName"--%> type="submit" value="TEST"/>
            </div>
        </div>
        <div id="div_user"><!--右边主体区域-->
            <div class="div_label">
                <label>用户</label>
            </div>
            <div class="div_table">
                <form id="form_user" action="" method="post">
                    <table id="table_user" border="2">
                        <p>
                            <tr id="tr_user_title">
                        <p>
                        <td><input class="checkbox_normal" type="checkbox"></input>用户ID</td>
                        <td>用户名</td>
                        <td>用户类型</td>
                        <td>用户密码</td>
                        <td>注册时间</td>
                        <td>权限</td>
                        <td>所属用户组</td>
                        </p>
                        </tr>
                        <tr>
                            <p>
                            <td><input class="checkbox_normal" type="checkbox"></input>temp</td>
                            <td>temp</td>
                            <td>temp</td>
                            <td>temp</td>
                            <td>temp</td>
                            <td>temp</td>
                            <td>temp</td>
                            </p>
                        </tr>
                        </p>
                    </table>
                </form>
            </div>
            <div class="div_button">
                <input id="btn_add_user" class="input_button_normal" type="button" value="添加用户"/>
                <input id="btn_del_user" class="input_button_normal" type="button" value="删除用户"/>
                <input id="btn_add_user2group" class="input_button_normal" type="button" value="添加用户到选中用户组"/>
                <input id="btn_show_singleton_user" class="input_button_normal" type="button" value="显示所有独立用户"/>
            </div>
        </div>
    </div><!--div_main-->
    <%--<div id="div_footer">--%>

    <%--</div><!--div_footer-->--%>
</div>
</body>
</html>
