<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<%@include file="DrawerBar.html" %>
<jsp:useBean id="oriEmployee" type="demo.Model.Employee" scope="request"></jsp:useBean>
<html>
<body>
<div class="mdui-container main-container mdui-text-left">
    <h1>您要修改的员工账号信息如下</h1>
    <form action="adminUpdateEmployee" method="post">
        <div class="mdui-textfield mdui-textfield-floating-label">
            <label class="mdui-textfield-label">员工ID</label>
            <input type="text" class="mdui-textfield-input" readonly size="10" name="EmId"
                   value=
                   <jsp:getProperty name="oriEmployee" property="employee_id"></jsp:getProperty>
            />
        </div>
        <div class="mdui-textfield mdui-textfield-floating-label">
            <label class="mdui-textfield-label">员工用户名</label>
            <input type="text" class="mdui-textfield-input" size="10" name="Username"
                   value=
                   <jsp:getProperty name="oriEmployee" property="employee_username"></jsp:getProperty>
            />
        </div>
        <div class="mdui-textfield mdui-textfield-floating-label">
            <label class="mdui-textfield-label">员工密码</label>
            <input type="text" class="mdui-textfield-input" size="10" name="Password"
                   value=
                   <jsp:getProperty name="oriEmployee" property="password"></jsp:getProperty>
            >
        </div>
        <div class="mdui-textfield mdui-textfield-floating-label">
            <label class="mdui-textfield-label">员工姓名</label>
            <input type="text" class="mdui-textfield-input" size="10" name="RealName"
                   value=
                   <jsp:getProperty name="oriEmployee" property="employee_name"></jsp:getProperty>
            />
        </div>
        <div class="mdui-textfield mdui-textfield-floating-label">
            <label class="mdui-textfield-label">员工性别</label>
            <input type="text" class="mdui-textfield-input" size="10" name="Gender"
                   value=
                   <jsp:getProperty name="oriEmployee" property="employee_gender"></jsp:getProperty>
            />
        </div>
        <button type="submit" class="mdui-btn mdui-btn-raised mdui-ripple mdui-color-theme-accent">修改信息</button>
    </form>
</div>
<script src="../../static/MDUI_files/mdui.min.js"></script>
<script type="text/javascript">
    //p for parent bar
    var p = document.getElementById("AccountSetting");
    var open = "mdui-collapse-item mdui-collapse-item-open";
    p.setAttribute("class", open);
    //c for child bar
    var c = document.getElementById("CustomerSetting");
    var active = "mdui-list-item mdui-ripple mdui-list-item-active";
    c.setAttribute('class', active);
</script>
</body>
</html>
