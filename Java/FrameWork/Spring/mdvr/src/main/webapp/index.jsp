<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/9/30 0030
  Time: 下午 22:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <%--使用/resources/css/main.css也可以？--%>
    <link href="/css/main.css" rel="stylesheet" type="text/css"/>
    <style type="text/css">
      /*.label_login{*/
        /*font-size:38px;*/
      /*}*/
    </style>
    <title>MDVR视频监控管理系统</title>
  </head>
  <body>
    <%System.out.println(request.getRealPath("/"));%>
    <form id="login" action="login" method="post">
      <label class="label_login">管理员</label>
      <input class="text_login" type="text" name="username"/>
      <label class="label_login">密码</label>
      <input class="text_login" type="password" name="password"/>
      <input id="button_login" type="submit" value="登陆"/>
    </form>
  <form action="reporting">
    <input id="button_login" type="submit" value="生成报表"/>
  </form>
  </body>
</html>
