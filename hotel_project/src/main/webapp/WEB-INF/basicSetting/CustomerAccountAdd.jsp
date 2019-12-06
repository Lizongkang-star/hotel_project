<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<%@include file="DrawerBar.html" %>

<div class="mdui-container main-container mdui-text-left">
    <h1>
        客户账号增加
    </h1>
    <form action="adminAddUser" method="post">
        <div class="mdui-textfield mdui-textfield-floating-label">
            <label class="mdui-textfield-label">客户用户名</label>
            <input type="text" class="mdui-textfield-input" size="10" name="customerUsernameAdd" required/>
        </div>
        <div class="mdui-textfield mdui-textfield-floating-label">
            <label class="mdui-textfield-label">客户密码</label>
            <input type="password" class="mdui-textfield-input" size="10" name="customerPasswordAdd" required/>
        </div>
        <div class="mdui-textfield mdui-textfield-floating-label">
            <label class="mdui-textfield-label">客户姓名</label>
            <input type="text" class="mdui-textfield-input" size="10" name="customerNameAdd" required/>
        </div>
        <div class="mdui-textfield mdui-textfield-floating-label">
            <label class="mdui-textfield-label">客户手机号</label>
            <input type="text" class="mdui-textfield-input" size="10" name="customerPhoneAdd" required/>
        </div>
        <div class="mdui-textfield mdui-textfield-floating-label">
            <label class="mdui-textfield-label">客户身份证号</label>
            <input type="text" class="mdui-textfield-input" size="10" name="customerIDNumberAdd" required/>
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
    var c = document.getElementById("CustomerSetting");
    var active = "mdui-list-item mdui-ripple mdui-list-item-active";
    c.setAttribute('class', active);
</script>
</body></html>


