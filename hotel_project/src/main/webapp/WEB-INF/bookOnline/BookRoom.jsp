<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="DrawerBar.html" %>

<form action="UserSubmitOrder" method="get">
    <div class="mdui-container doc-container">
        <div class="mdui-container main-container">
            <h1>
                订单详情
            </h1>
            房间类型：${sessionScope.type}
            <br>
            房间价格（元）：${sessionScope.startTime}
            <br>
            入住时间：${sessionScope.endTime}
            <br>
            退房时间：${sessionScope.dateEnd}
            <br>
            <jsp:useBean id="LoginedCustomer" scope="session" type="demo.Model.Customer"></jsp:useBean>
            客户ID：
            <jsp:getProperty name="LoginedCustomer" property="customer_id"></jsp:getProperty>
            <br>
            客户姓名：
            <jsp:getProperty name="LoginedCustomer" property="real_name"></jsp:getProperty>
            <br>
            客户身份证号码：
            <jsp:getProperty name="LoginedCustomer" property="id_card"></jsp:getProperty>
            <br>
            <button type="submit" class="mdui-btn mdui-btn-raised mdui-ripple mdui-color-theme-accent">确认预定</button>
        </div>
    </div>
</form>

<script type="text/javascript">
    //p for parent bar
    var p = document.getElementById("BookRoom");
    var open = "mdui-collapse-item mdui-collapse-item-open";
    p.setAttribute("class", open);
    //c for child bar
    var c = document.getElementById("AvailableRoomQuery");
    var active = "mdui-list-item mdui-ripple mdui-list-item-active";
    c.setAttribute('class', active);
</script>
<script src="../../static/MDUI_files/mdui.min.js"></script>