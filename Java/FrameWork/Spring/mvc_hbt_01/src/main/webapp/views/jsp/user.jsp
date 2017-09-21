<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/9/19 0019
  Time: 下午 19:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://zhangjihao.com/page" prefix="t" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>图书列表</title>
</head>

<body>
<h1 align="center">用户列表</h1>
<TABLE align="center">
    <tr>
        <td>用户id</td>
        <td>姓名</td>
        <td>密码</td>
        <td>注册日期</td>
        <%--<td>ISBN号</td>--%>
    </tr>
    <tr>
        <c:forEach items="${users}" var="user" varStatus="status">
        <td>${user.id}</td>
        <td>${user.name}</td>
        <td>${user.password}</td>
        <td>${user.datetime}</td>
            <%--<td>${user.photo}</td>--%>
        <%--<c:if test="${status.count % 4 == 0}">--%>
    </tr>
    <tr>
        <%--</c:if>--%>
        </c:forEach>
    </tr>
    <tr>
        <td>session:${requestScope.users[0].id}</td>
        <%--<td>session:${users[1].id}</td>--%>
    </tr>
</TABLE>
<!-- 注意了，两个字母实现通用分页 -->
<t:p/>
<%--在当前真实目录下+paging.do--%>
<form action="paging.do" method="post">
    <%--<form action="login" method="post">--%>
    currentPage:<input type="text" name="currentPage">
    <p>
        next:<input type="text" name="next">
    <p>
        <input type="submit" name="action_log" value="go">
</form>
</body>
</html>

