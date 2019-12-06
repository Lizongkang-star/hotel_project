<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="DrawerBar.html" %>
<div class="mdui-container main-container mdui-text-left">
    <h1>
        符合订单要求的可用房间如下
    </h1>
    <form action="employeePreservationCheckin" method="post">
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
                    <th>房间状态</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="room" items="${requestScope.AvailableQueryResult}"
                           varStatus="status">
                    <tr>
                        <td>${room.room_id}</td>
                        <td>${room.room_number}</td>
                        <td>${room.room_type}</td>
                        <td>${room.room_floor}</td>
                        <td>${room.room_direction}</td>
                        <td>${room.room_description}</td>
                        <td>${room.room_status}</td>
                        <td>
                            <label class="mdui-radio">
                                <input id="bookChooseButton" type="radio" name="bookedRoomNumber" value=${room.room_number}>
                                <i class="mdui-radio-icon"></i>
                            </label>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <br>
        <button type="submit" class="mdui-btn mdui-btn-raised mdui-ripple mdui-color-theme-accent">提交</button>
    </form>

</div>

<script type="text/javascript">


</script>

<script src="../../static/MDUI_files/mdui.min.js"></script>
<script type="text/javascript">
    //p for parent bar
    var p = document.getElementById("ReceptionManagement");
    var open = "mdui-collapse-item mdui-collapse-item-open";
    p.setAttribute("class", open);
    //c for child bar
    var c = document.getElementById("PreservationCheckin");
    var active = "mdui-list-item mdui-ripple mdui-list-item-active";
    c.setAttribute('class', active);
</script>