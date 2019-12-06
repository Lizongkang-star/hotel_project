<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<%@include file="DrawerBar.html" %>
<div class="mdui-container doc-container main-section" style="display: flex;flex-direction: column;">
    <div class="mdui-container main-container" style="display: flex;flex-direction: column;justify-content: center;">
        <div class="mdui-list" style="size: 100px">
            <a href="go?url=basicSetting/CustomerOrdersQuery" class="mdui-list-item mdui-ripple">订单查询</a>
            <a href="go?url=basicSetting/CustomerOrdersModify" class="mdui-list-item mdui-ripple">订单修改</a>
        </div>
    </div>
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