<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<%@include file="DrawerBar.html" %>

<div class="mdui-container main-container" style="display: flex;flex-direction: column;justify-content: center;">

    <h1>
        所有客户信息如下：
    </h1>
    <form>
        <div class="mdui-table-fluid">
            <table class="mdui-table mdui-table-hoverable">
                <thead>
                <tr>
                    <th>用户Id</th>
                    <th>用户名</th>
                    <th>用户姓名</th>
                    <th>电话号码</th>
                    <th>身份证号</th>
                    <th>性别</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="user" items="${requestScope.AllUserList}"
                           varStatus="status">
                    <tr>
                        <td id="id">${user.customer_id}</td>
                        <td id="name">${user.username}</td>
                        <td id="realname">${user.real_name}</td>
                        <td id="phone">${user.customer_phone}</td>
                        <td id="idcard">${user.id_card}</td>
                        <td id="gender">${user.customer_gender}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <br>
    </form>


</div>


<script src="../../static/MDUI_files/mdui.min.js"></script>
<script type="text/javascript">
    //p for parent bar
    var p = document.getElementById("AccountSetting");
    var open = "mdui-collapse-item mdui-collapse-item-open";
    p.setAttribute("class", open);
    //c for child bar
    var c = document.getElementById("CustomerAccountShow");
    var active = "mdui-list-item mdui-ripple mdui-list-item-active";
    c.setAttribute('class', active);
</script>