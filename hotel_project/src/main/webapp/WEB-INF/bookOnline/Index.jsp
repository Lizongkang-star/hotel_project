<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="DrawerBar.html" %>

<html>
<head>
    <title>欢迎使用在线酒店系统</title>
</head>
<body>
<!-- 首屏 -->
<div class="mdui-container doc-container" style="display: flex;flex-direction: column;">
    <div class="mdui-container main-container" style="display: flex;flex-direction: column;justify-content: center;">
        <h1>本酒店信息介绍</h1>
    </div>

</div>
<div>
    <div class="mdui-typo-title">
        酒店：
    </div>
    <div class="mdui-typo">
        <p>&nbsp;&nbsp;${hotelname}</p>
        <br>
    </div>

    <div class="mdui-typo-title">
        酒店简介：
    </div>
    <div class="mdui-typo">
        <p>&nbsp;&nbsp;${introdution}</p>
            <br>
    </div>
    <div class="mdui-typo-title">
        地理信息：
    </div>
    <div class="mdui-typo">
        <p>&nbsp;&nbsp;${locationinfo}</p>
            <br>
    </div>

    <div class="mdui-typo-title">
        交通信息：
    </div>
    <div class="mdui-typo">
        <p>&nbsp;&nbsp;${trafficinfo}</p>
            <br>
    </div>

</div>

<script src="../../static/MDUI_files/mdui.min.js"></script>
</body>
</html>

