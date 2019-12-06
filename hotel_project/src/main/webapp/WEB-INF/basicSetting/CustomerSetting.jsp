<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<%@include file="DrawerBar.html" %>
<!-- 首屏 2-->
<div class="mdui-container doc-container" style="display: flex;flex-direction: column;">
    <div class="mdui-container main-container" style="display: flex;flex-direction: column;justify-content: center;">

        <div class="mdui-list" style="size: 100px">
            <a href="showAllUser" class="mdui-list-item mdui-ripple">查看客户账号</a>
            <a href="go?url=basicSetting/CustomerAccountAdd" class="mdui-list-item mdui-ripple">客户账号增加</a>
            <a href="go?url=basicSetting/CustomerAccountModifyID" class="mdui-list-item mdui-ripple">客户账号修改</a>
            <a href="go?url=basicSetting/CustomerAccountDelete" class="mdui-list-item mdui-ripple">客户账号删除</a>
        </div>


        <div class="main-btn-wrapper">
            <form action="go?url=basicSetting/CustomerAccountAdd" method="get">
                <input type="submit" class="mdui-btn main-btn mdui-ripple mdui-ripple-white" value="客户账号增加">
            </form>
            <br>
            <form action="go?url=basicSetting/CustomerAccountModifyID" method="get">
                <input type="submit" class="mdui-btn main-btn mdui-ripple mdui-ripple-white" value="客户账号修改">
            </form>
            <br>
            <form action="go?url=basicSetting/CustomerAccountDelete" method="get">
                <input type="submit" class="mdui-btn main-btn mdui-ripple mdui-ripple-white" value="客户账号删除">
            </form>
            <br>
        </div>
    </div>

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