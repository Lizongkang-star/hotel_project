<%@ page import="demo.Model.Orders" %>
<%@ page import="demo.Util.DateTransform" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<%@include file="DrawerBar.html" %>

<div class="mdui-container main-container mdui-text-left">
    <h1>
        您要修改的订单信息如下：
    </h1>
    <div class="mdui-table-fluid">
        <table class="mdui-table mdui-table-hoverable">
            <jsp:useBean id="queryOrder" type="demo.Model.Orders" scope="request"></jsp:useBean>
            <tbody>
            <tr>
                <th>订单ID</th>
                <th>
                    <jsp:getProperty name="queryOrder" property="orders_id"></jsp:getProperty>
                </th>
            </tr>
            <tr>
                <th>房间号</th>
                <th>
                    <jsp:getProperty name="queryOrder" property="room_number"></jsp:getProperty>
                </th>
            </tr>
            <tr>
                <th>客户名</th>
                <th>
                    <jsp:getProperty name="queryOrder" property="customer_id"></jsp:getProperty>
                </th>
            </tr>
            <tr>
                <th>客户姓名</th>
                <th>
                    <jsp:getProperty name="queryOrder" property="customer_name"></jsp:getProperty>
                </th>
            </tr>
            <tr>
                <th>客户身份证号</th>
                <th>
                    <jsp:getProperty name="queryOrder" property="customer_idcard"></jsp:getProperty>
                </th>
            </tr>
            <tr>
                <th>入住日期</th>
                <th>
                    <%= DateTransform.Date2String(((Orders)request.getAttribute("queryOrder")).getStart_time()) %>
                </th>
            </tr>
            <tr>
                <th>结束日期</th>
                <th>
                    <%= DateTransform.Date2String(((Orders)request.getAttribute("queryOrder")).getEnd_time()) %>
                </th>
            </tr>
            <tr>
                <th>房间类型</th>
                <th>
                    <jsp:getProperty name="queryOrder" property="orders_type"></jsp:getProperty>
                </th>
            </tr>
            <tr>
                <th>订单状态</th>
                <th>
                    <jsp:getProperty name="queryOrder" property="orders_status"></jsp:getProperty>
                </th>
            </tr>
            </tbody>
        </table>
    </div>
    <br>
    <h1>
        将订单信息修改为如下
    </h1>
    <form action="adminCustomerOrdersModify" method="post">
        <div class="mdui-textfield mdui-textfield-floating-label">
            <label class="mdui-textfield-label">订单ID</label>
            <input class="mdui-textfield-input" type="text" name="orderID" readonly
                   value=<jsp:getProperty name="queryOrder" property="orders_id"></jsp:getProperty>>
        </div>
        <div class="mdui-textfield mdui-textfield-floating-label">
            <label class="mdui-textfield-label">房间号</label>
            <input class="mdui-textfield-input" type="text" name="roomID"
                   value=<jsp:getProperty name="queryOrder" property="room_number"></jsp:getProperty>>
        </div>

        <div class="mdui-textfield mdui-textfield-floating-label">
            <label class="mdui-textfield-label">客户用户名</label>
            <input class="mdui-textfield-input" type="text" name="customerID"
                   value=<jsp:getProperty name="queryOrder" property="customer_id"></jsp:getProperty>>
        </div>
        <div class="mdui-textfield mdui-textfield-floating-label">
            <label class="mdui-textfield-label">客户姓名</label>
            <input class="mdui-textfield-input" type="text" name="customerName"
                   value=<jsp:getProperty name="queryOrder" property="customer_name"></jsp:getProperty>>
        </div>
        <div class="mdui-textfield mdui-textfield-floating-label">
            <label class="mdui-textfield-label">入住日期</label>
            <input class="mdui-textfield-input" type="date" name="dateBegin"
                   value=<jsp:getProperty name="queryOrder" property="start_time"></jsp:getProperty>>
        </div>
        <div class="mdui-textfield mdui-textfield-floating-label">
            <label class="mdui-textfield-label">结束日期</label>
            <input class="mdui-textfield-input" type="date" name="dateEnd"
                   value=<jsp:getProperty name="queryOrder" property="end_time"></jsp:getProperty>>
        </div>
        <div class="mdui-textfield mdui-textfield-floating-label">
            <label class="mdui-textfield-label">房间类型</label>
            <input class="mdui-textfield-input" type="text" name="roomType"
                   value=<jsp:getProperty name="queryOrder" property="orders_type"></jsp:getProperty>>
        </div>
        <div class="mdui-textfield mdui-textfield-floating-label">
            <label class="mdui-textfield-label">订单状态</label>
            <input class="mdui-textfield-input" type="text" name="orderStatus"
                   value=<jsp:getProperty name="queryOrder" property="orders_status"></jsp:getProperty>>
        </div>
        <br>
        <button type="submit" class="mdui-btn mdui-btn-raised mdui-ripple mdui-color-theme-accent">修改信息</button>
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