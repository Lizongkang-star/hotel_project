<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<%@include file="DrawerBar.html" %>
<html>
<head><title>房态统计查询结果</title></head>
<body>
<div class="mdui-container main-container mdui-text-left">
    <h1>
        房间信息如下
    </h1>
    <div class="mdui-table-fluid">
        <table class="mdui-table mdui-table-hoverable">
            <thead>
            <tr>
                <th>房间ID</th>
                <th>房间号</th>
                <th>房间类型</th>
                <th>房间楼层</th>
                <th>房间方位</th>
                <th>房间描述</th>
                <th>房间大小(平方米)</th>
                <th>房间状态</th>
                <th>床位数</th>
                <th>是否可加床</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="room" items="${sessionScope.roomQueryResultByType}"
                       varStatus="status">
                <tr>
                    <td>${room.room_id}</td>
                    <td>${room.room_number}</td>
                    <td>${room.room_type}</td>
                    <td>${room.room_floor}</td>
                    <td>${room.room_direction}</td>
                    <td>${room.room_description}</td>
                    <td>${room.room_square}</td>
                    <td>${room.room_status}</td>
                    <td>${room.bed_num}</td>
                    <td>${room.can_addbed}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>


<script src="../../static/MDUI_files/mdui.min.js"></script>
<script type="text/javascript">
    //p for parent bar
    var p = document.getElementById("RoomManagement");
    var open = "mdui-collapse-item mdui-collapse-item-open";
    p.setAttribute("class", open);
    //c for child bar
    var c = document.getElementById("RoomReport");
    var active = "mdui-list-item mdui-ripple mdui-list-item-active";
    c.setAttribute('class', active);
</script>
</body>
</html>

