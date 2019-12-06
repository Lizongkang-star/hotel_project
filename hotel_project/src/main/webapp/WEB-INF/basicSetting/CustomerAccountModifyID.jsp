<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<%@include file="DrawerBar.html" %>
<html>
<head><title></title></head>
<body>
<div class="mdui-container main-container mdui-text-left">
    <h1>
        请选择要设置的客户账号ID
    </h1>

    <form action="CustomerAccountModifyID" method="post">
        客户账户ID:
        <select class="mdui-select" id="roomTypeSelect" name="userIDModify">
            <c:forEach var="userId" items="${sessionScope.AllCustomerID}"
                       varStatus="status">
                <option>${userId}</option>
            </c:forEach>
        </select>

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
</body>
</html>




