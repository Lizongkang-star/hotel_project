<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="DrawerBar.html" %>
<html>
<head>
    <jsp:useBean id="LoginedAdmin" type="demo.Model.Administrator" scope="session"></jsp:useBean>
    <title>修改密码</title>

</head>
<body>
<!-- 首屏 -->
<div class="mdui-container main-container mdui-text-left">
    <h1>请确认信息并修改</h1>

    <form action="AdminUpPw" method="post">
        <div class="mdui-textfield mdui-textfield-floating-label">
            <label class="mdui-textfield-label">用户名</label>
            <input type="text" class="mdui-textfield-input" size="10" name="Username" readonly
                   value=
                   <jsp:getProperty name="LoginedAdmin" property="username"></jsp:getProperty>
            />
        </div>
        <div class="mdui-textfield mdui-textfield-floating-label">
            <label class="mdui-textfield-label">密码</label>
            <input type="text" class="mdui-textfield-input" size="10" name="Password" required
                   value=
                   <jsp:getProperty name="LoginedAdmin" property="password"></jsp:getProperty>
            >
        </div>
        <button type="submit" class="mdui-btn mdui-btn-raised mdui-ripple mdui-color-theme-accent">确认</button>
    </form>
</div>

<script src="../../static/MDUI_files/mdui.min.js"></script>
</body>
</html>

