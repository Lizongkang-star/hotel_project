<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="DrawerBar.html" %>
<div class="mdui-container main-container mdui-text-left">
    <h1>
        请选择要维修的房间ID号码
    </h1>
    <form action="employeeRoomRepair" method="post">
        房间ID:
        <select class="mdui-select" name="roomRepairOfRoomID">
            <c:forEach var="roomID" items="${sessionScope.AllRoomID}"
                       varStatus="status">
                <option>${roomID}</option>
            </c:forEach>
        </select>
        <button type="submit" class="mdui-btn mdui-btn-raised mdui-ripple mdui-color-theme-accent">提交</button>
    </form>
    <br>
    <h1>
        请选择维修完成的房间ID号码
    </h1>
    <form action="employeeRoomRepairDone" method="post">
        房间ID:
        <select class="mdui-select" name="roomRepairDoneOfRoomID">
            <c:forEach var="roomID" items="${sessionScope.AllRoomID}"
                       varStatus="status">
                <option>${roomID}</option>
            </c:forEach>
        </select>
        <button type="submit" class="mdui-btn mdui-btn-raised mdui-ripple mdui-color-theme-accent">提交</button>
    </form>
</div>


<script src="../../static/MDUI_files/mdui.min.js"></script>
<script type="text/javascript">
    //p for parent bar
    var p = document.getElementById("RoomManagement");
    var open = "mdui-collapse-item mdui-collapse-item-open";
    p.setAttribute("class", open);
    //c for child bar
    var c = document.getElementById("RepairManagement");
    var active = "mdui-list-item mdui-ripple mdui-list-item-active";
    c.setAttribute('class', active);
</script>