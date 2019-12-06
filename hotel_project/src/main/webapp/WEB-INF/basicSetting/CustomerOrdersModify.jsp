<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<%@include file="DrawerBar.html" %>
<div class="mdui-container main-container mdui-text-left">
    <h1>请选择要修改的订单ID号</h1>
    <form action="adminCustomerOrdersModifyID" method="post">
        订单ID：
        <select class="mdui-select" id="roomTypeSelect" name="IDOfOrderRoomModify">
            <c:forEach var="ordersID" items="${sessionScope.AllOrdersID}"
                       varStatus="status">
                <option>${ordersID}</option>
            </c:forEach>
        </select>

        <button type="submit" class="mdui-btn mdui-btn-raised mdui-ripple mdui-color-theme-accent">提交</button>
    </form>
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
</body></html>

