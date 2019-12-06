<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="DrawerBar.html" %>

<div class="mdui-container doc-container" style="display: flex;flex-direction: column;">
    <h1>
        您的帐号信息
    </h1>
    <div class="mdui-table-fluid">
        <table class="mdui-table mdui-table-hoverable">
            <thead>
            <tr>
                <th>用户名</th>
                <th>姓名</th>
                <th>电话号码</th>
                <th>身份证号</th>
            </tr>
            </thead>
            <tbody>
            <jsp:useBean id="LoginedCustomer" scope="session" type="demo.Model.Customer"></jsp:useBean>
            <tr>
                <td>
                    <jsp:getProperty name="LoginedCustomer" property="username"></jsp:getProperty>
                </td>
                <td>
                    <jsp:getProperty name="LoginedCustomer" property="real_name"></jsp:getProperty>
                </td>
                <td>
                    <jsp:getProperty name="LoginedCustomer" property="customer_phone"></jsp:getProperty>
                </td>
                <td>
                    <jsp:getProperty name="LoginedCustomer" property="id_card"></jsp:getProperty>
                </td>
            </tr>
            </tbody>
        </table>
    </div>
</div>

<script type="text/javascript">
    //p for parent bar
    var p = document.getElementById("PersonalSetting");
    var open = "mdui-collapse-item mdui-collapse-item-open";
    p.setAttribute("class", open);
    //c for child bar
    var c = document.getElementById("PersonalInformation");
    var active = "mdui-list-item mdui-ripple mdui-list-item-active";
    c.setAttribute('class', active);
</script>
<script src="../../static/MDUI_files/mdui.min.js"></script>