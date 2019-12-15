
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE html >
<html>
<head>
    <base href="<%=basePath%>">
    <title>404</title>
</head>
<body>
<h2>404</h2>
<h3>抱歉，您访问的页面好像被火星汪叼走了!</h3>
</body>
</html>