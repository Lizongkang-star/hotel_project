<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<%@include file="DrawerBar.html" %>


<%--Context--%>
<div class="mdui-container main-container mdui-text-left">
    <h1>
        您要查询的订单情况如下：
    </h1>
    <p>

    </p>

    <div class="mdui-table-fluid">
        <table class="mdui-table mdui-table-hoverable">
            <thead>
            <tr>
                <th>订单ID</th>
                <th>房间ID</th>
                <th>客户ID</th>
                <th>客户名</th>
                <th>订单开始日期</th>
                <th>订单结束日期</th>
                <th>订单状态</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="orders" items="${requestScope.CustomerOrdersQueryResult}"
                       varStatus="status">
                <tr>
                    <td>${orders.orders_id}</td>
                    <td>${orders.room_number}</td>
                    <td>${orders.customer_id}</td>
                    <td>${orders.customer_name}</td>
                    <td><fmt:formatDate value="${orders.start_time}" pattern="yyyy年M月d日" /></td>
                    <td><fmt:formatDate value="${orders.end_time}" pattern="yyyy年M月d日" /></td>
                    <td>${orders.orders_status}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<script src="../../static/MDUI_files/mdui.min.js"></script>
<script type="text/javascript">
    //p for parent bar
    var p = document.getElementById("RoomPreservationManagement");
    var open = "mdui-collapse-item mdui-collapse-item-open";
    p.setAttribute("class", open);
    //c for child bar
    var c = document.getElementById("BookManagement");
    var active = "mdui-list-item mdui-ripple mdui-list-item-active";
    c.setAttribute('class', active);
</script>