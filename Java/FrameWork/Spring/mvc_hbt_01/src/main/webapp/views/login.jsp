<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/9/16 0016
  Time: 下午 21:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<form action="login.do" method="post">
<%--<form action="login" method="post">--%>
    username:<input type="text" name = "username" ><p>
    password:<input type="password" name = "password" ><p>
    <input type="submit" name="action_log" value="登录">
    <input type="submit" name="action_log" value="注册">
</form>
</body>
</html>
