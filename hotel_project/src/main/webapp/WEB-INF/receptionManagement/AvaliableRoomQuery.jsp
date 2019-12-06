<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="DrawerBar.html" %>
<html>
<head><title>可用房查询</title></head>
<body>
<div>
    <p>后续功能，敬请期待</p>
</div>
<script src="../../static/MDUI_files/mdui.min.js"></script>
<script type="text/javascript">
    //p for parent bar
    var p = document.getElementById("RoomManagement");
    var open = "mdui-collapse-item mdui-collapse-item-open";
    p.setAttribute("class", open);
    //c for child bar
    var c = document.getElementById("AvaliableRoomQuery");
    var active = "mdui-list-item mdui-ripple mdui-list-item-active";
    c.setAttribute('class', active);
</script>

</body>
</html>