<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<%@include file="DrawerBar.html" %>

<div class="mdui-container main-container" style="display: flex;flex-direction: column;justify-content: center;">

    <h1>
        当前控房情况
    </h1>
    <form action="RoomPreservationAdd" method="post">
        <div class="mdui-table-fluid">
            <table class="mdui-table mdui-table-hoverable">
                <thead>
                <tr>
                    <th>房间类型</th>
                    <th>房间总数量</th>
                    <th>已控房数量</th>
                    <th>新增控房数量</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="roomCategory" items="${requestScope.roomCategoryArrayList}"
                           varStatus="status">
                    <tr>
                        <td id="typeName">${roomCategory.roomcategory_name}</td>
                        <td id="totalNumber">${roomCategory.total_number}</td>
                        <td id="LockedNumber">${roomCategory.locked_number}</td>
                        <td id="addLockedNumber"><input type="number" name="addLockedNumber" min="0" value="0" size="5"
                                                        max="${roomCategory.total_number - roomCategory.locked_number}">
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <br>
        <button type="submit" class="mdui-btn mdui-btn-raised mdui-ripple mdui-color-theme-accent">确定</button>
    </form>


</div>


<script src="../../static/MDUI_files/mdui.min.js"></script>
<script type="text/javascript">
    //p for parent bar
    var p = document.getElementById("RoomPreservationManagement");
    var open = "mdui-collapse-item mdui-collapse-item-open";
    p.setAttribute("class", open);
    //c for child bar
    var c = document.getElementById("RoomPreservation");
    var active = "mdui-list-item mdui-ripple mdui-list-item-active";
    c.setAttribute('class', active);
</script>