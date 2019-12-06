<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<%@include file="DrawerBar.html" %>
<html>
<head><title></title></head>
<body>
<div class="mdui-container main-container mdui-text-left">
    <h1>
        历史客人情况报表
    </h1>
    <p>

    </p>
    <div class="mdui-table-fluid">
        <table class="mdui-table mdui-table-hoverable">
            <thead>
            <tr>
                <th>ID</th>
                <th>身份号码</th>
                <th>客人姓名</th>
                <th>房间号</th>
                <th>入住日期</th>
                <th>结束日期</th>
                <%--<th>订单状态</th>--%>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="customerReport" items="${requestScope.customerReportArrayList}"
                       varStatus="status">
                <tr>
                    <td>${customerReport.userID}</td>
                    <td>${customerReport.IDNumber}</td>
                    <td>${customerReport.customerName}</td>
                    <td>${customerReport.roomID}</td>
                    <td>${customerReport.startTime}</td>
                    <td>${customerReport.endTime}</td>
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
    var c = document.getElementById("ReportOfLivedCustomer");
    var active = "mdui-list-item mdui-ripple mdui-list-item-active";
    c.setAttribute('class', active);
</script>

</body>
</html>