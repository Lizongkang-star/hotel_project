<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="DrawerBar.html" %>

<div class="mdui-container doc-container" style="display: flex;flex-direction: column;">
    <div class="mdui-container main-container" style="display: flex;flex-direction: column;justify-content: center;">
        <form action="customerRoomQuery" method="post">
            <h1>请输入起始时间</h1>
            <br>
            入住日期：<input type="date" value="datetime-local" id="dateBeginID" name="dateBegin" min="today" required/>
            <br>
            离店日期：<input type="date" value="datetime-local" id="dateEndID" name="dateEnd" min="today" required/>
            <br>
            <br>
            <button type="submit" class="mdui-btn mdui-btn-raised mdui-ripple mdui-color-theme-accent">查询</button>
        </form>
    </div>
</div>

<script type="text/javascript">
    //限制入住日期从今天开始
    document.getElementById("dateBeginID").setAttribute("min", new Date().toISOString().substring(0, 10));
</script>

<script type="text/javascript">
    //限制结束日期日期从今天开始
    document.getElementById("dateEndID").setAttribute("min", new Date().toISOString().substring(0, 10));
</script>
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