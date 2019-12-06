<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="DrawerBar.html" %>
<div class="mdui-container main-container mdui-text-left">
    <h1>
        退房账单信息
    </h1>
    <jsp:useBean id="checkoutBill" type="demo.Model.TempModel.Bill" scope="session"></jsp:useBean>
    客户名：
    <jsp:getProperty name="checkoutBill" property="customerID"></jsp:getProperty>
    <br>
    订单ID：
    <jsp:getProperty name="checkoutBill" property="orderID"></jsp:getProperty>
    <br>
    房间ID：
    <jsp:getProperty name="checkoutBill" property="roomID"></jsp:getProperty>
    <br>
    房间号：
    <jsp:getProperty name="checkoutBill" property="roomNumber"></jsp:getProperty>
    <br>
    房间类型：
    <jsp:getProperty name="checkoutBill" property="type"></jsp:getProperty>
    <br>
    楼层：
    <jsp:getProperty name="checkoutBill" property="floor"></jsp:getProperty>
    <br>
    入住日期：
    <jsp:getProperty name="checkoutBill" property="startTime"></jsp:getProperty>
<%--    <%= DateTransform.Date2String(((Bill) session.getAttribute("checkoutBill")).getStartTime()) %>--%>
    <br>
    退房日期：
    <jsp:getProperty name="checkoutBill" property="endTime"></jsp:getProperty>
    <br>
</div>


<script src="../../static/MDUI_files/mdui.min.js"></script>
<script type="text/javascript">
    //p for parent bar
    var p = document.getElementById("ReceptionManagement");
    var open = "mdui-collapse-item mdui-collapse-item-open";
    p.setAttribute("class", open);
    //c for child bar
    var c = document.getElementById("Checkout");
    var active = "mdui-list-item mdui-ripple mdui-list-item-active";
    c.setAttribute('class', active);
</script>