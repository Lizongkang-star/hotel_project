<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>
    注册成功！3秒后跳转至登录界面。
</h1>
<%
    response.setHeader("Refresh", "3;URL=go?url= /bookOnline/Index");
%>
</body>
</html>
