<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<%@include file="DrawerBar.html" %>

<div class="mdui-container main-container" style="display: flex;flex-direction: column;justify-content: center;">
    <h1>
        员工信息如下：
    </h1>
    <form>
        <div class="mdui-table-fluid">
            <table class="mdui-table mdui-table-hoverable">
                <thead>
                <tr>
                    <th>员工ID</th>
                    <th>用户名</th>
                    <th>员工姓名</th>
                    <th>性别</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="user" items="${requestScope.AllEmployeeList}"
                           varStatus="status">
                    <tr>
                        <td id="id">${user.employee_id}</td>
                        <td id="name">${user.employee_username}</td>
                        <td id="realname">${user.employee_name}</td>
                        <td id="phone">${user.employee_gender}</td>
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
    var c = document.getElementById("ReceptionistAccountShow");
    var active = "mdui-list-item mdui-ripple mdui-list-item-active";
    c.setAttribute('class', active);
</script>