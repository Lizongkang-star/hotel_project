<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="DrawerBar.html" %>

<div class="mdui-container main-container mdui-text-left">
    <h1>
        请选择要续住的相关信息
    </h1>
    <form action="employeeRoomExtend" method="post">
        订单ID：
        <select class="mdui-select" id="roomTypeSelect" name="orderIDExtend">
            <c:forEach var="ordersID" items="${sessionScope.AllOrdersID}"
                       varStatus="status">
                <option>${ordersID}</option>
            </c:forEach>
        </select>
        <br>
        续住日期：<input type="date" value="datetime-local" id="DateEndExtend" name="DateEndExtend" min="today" required/>
        <button type="submit" class="mdui-btn mdui-btn-raised mdui-ripple mdui-color-theme-accent">提交</button>
    </form>
</div>

<script type="text/javascript">
    //限制入住日期从今天开始
    document.getElementById("DateEndExtend").setAttribute("min", new Date().toISOString().substring(0, 10));
</script>

<script src="../../static/MDUI_files/mdui.min.js"></script>
<script type="text/javascript">
    //p for parent bar
    var p = document.getElementById("ReceptionManagement");
    var open = "mdui-collapse-item mdui-collapse-item-open";
    p.setAttribute("class", open);
    //c for child bar
    var c = document.getElementById("RoomExtend");
    var active = "mdui-list-item mdui-ripple mdui-list-item-active";
    c.setAttribute('class', active);
</script>