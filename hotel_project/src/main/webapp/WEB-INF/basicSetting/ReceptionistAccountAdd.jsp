<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<%@include file="DrawerBar.html" %>
<%--Context--%>
<div class="mdui-container main-container mdui-text-left">
    <h1>
        请输入要增加的接待员信息
    </h1>
    <form action="adminAddEmployee" method="post">
        <div class="mdui-textfield mdui-textfield-floating-label">
            <label class="mdui-textfield-label">接待员用户名</label>
            <input type="text" class="mdui-textfield-input" size="10" name="receptionistUsernameAdd" required/>
        </div>
        <div class="mdui-textfield mdui-textfield-floating-label">
            <label class="mdui-textfield-label">接待员密码</label>
            <input type="password" class="mdui-textfield-input" size="10" name="receptionistPasswordAdd" required/>
        </div>
        <div class="mdui-textfield mdui-textfield-floating-label">
            <label class="mdui-textfield-label">接待员姓名</label>
            <input type="text" class="mdui-textfield-input" size="10" name="receptionistNameAdd" required/>
        </div>
        <div class="mdui-textfield mdui-textfield-floating-label">
            <label class="mdui-textfield-label">接待员性别</label>
            <input type="text" class="mdui-textfield-input" size="10" name="receptionistGenderAdd" required/>
        </div>
        <button type="submit" class="mdui-btn mdui-btn-raised mdui-ripple mdui-color-theme-accent">提交</button>
    </form>

</div>

<script src="../../static/MDUI_files/mdui.min.js"></script>
<script type="text/javascript">
    //p for parent bar
    var p = document.getElementById("AccountSetting");
    var open = "mdui-collapse-item mdui-collapse-item-open";
    p.setAttribute("class", open);
    //c for child bar
    var c = document.getElementById("ReceptionistSetting");
    var active = "mdui-list-item mdui-ripple mdui-list-item-active";
    c.setAttribute('class', active);
</script>

</body></html>

