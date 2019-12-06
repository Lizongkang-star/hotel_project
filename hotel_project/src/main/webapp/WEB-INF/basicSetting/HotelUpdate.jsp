<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<%@include file="DrawerBar.html" %>
<jsp:useBean id="Hotel" type="demo.Model.Hotel" scope="request"></jsp:useBean>
<html>
<body>
<div class="mdui-container main-container mdui-text-left">
    <h1>请在下面修改酒店信息</h1>

    <form action="hotelUpdate" method="post">
        <div class="mdui-textfield mdui-textfield-floating-label">
            <label class="mdui-textfield-label">酒店名</label>
            <input type="text" class="mdui-textfield-input" readonly size="10" name="name"
                   value=
                   <jsp:getProperty name="Hotel" property="hotel_name"></jsp:getProperty>
            />
        </div>
        <div class="mdui-textfield mdui-textfield-floating-label">
            <label class="mdui-textfield-label">介绍</label>
            <input type="text" class="mdui-textfield-input" size="10" name="introduction"
                   value=
                   <jsp:getProperty name="Hotel" property="introduction"></jsp:getProperty>
            />
        </div>
        <div class="mdui-textfield mdui-textfield-floating-label">
            <label class="mdui-textfield-label">位置信息</label>
            <input type="text" class="mdui-textfield-input" size="10" name="location"
                   value=
                   <jsp:getProperty name="Hotel" property="location_info"></jsp:getProperty>
            >
        </div>
        <div class="mdui-textfield mdui-textfield-floating-label">
            <label class="mdui-textfield-label">交通信息</label>
            <input type="text" class="mdui-textfield-input" size="10" name="traffic"
                   value=
                   <jsp:getProperty name="Hotel" property="traffic_Info"></jsp:getProperty>
            />
        </div>
        <button type="submit" class="mdui-btn mdui-btn-raised mdui-ripple mdui-color-theme-accent">修改信息</button>
    </form>
</div>
<script src="../../static/MDUI_files/mdui.min.js"></script>
<script type="text/javascript">
    //p for parent bar
    var p = document.getElementById("AccountSetting");
    var open = "mdui-collapse-item mdui-collapse-item-open";
    p.setAttribute("class", open);
    //c for child bar
    var c = document.getElementById("CustomerSetting");
    var active = "mdui-list-item mdui-ripple mdui-list-item-active";
    c.setAttribute('class', active);
</script>
</body>
</html>