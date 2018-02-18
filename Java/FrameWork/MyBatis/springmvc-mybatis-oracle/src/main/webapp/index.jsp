<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/11/15 0015
  Time: 下午 13:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<form action="/batis/insert" method="post">
    <input type="text" name="username">username:</input>
    <input type="password" name="password">password:</input>
    <input type="submit"></input>
</form>
<div>
    <form method="post" action="/batis/upload_file" enctype="multipart/form-data"  >
        <input type="file"  name="upLoadFile" value="选择上传的文件" />
        <!-- Html5 多文件上传   multiple="multiple" -->
        <input type="submit" value="上传单个文件测试"/>
    </form>
</div>
</body>
</html>
