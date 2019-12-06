<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="renderer" content="webkit">
    <meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=no">
    <title></title>
    <link rel="stylesheet" href="../static/MDUI_files/mdui.min.css">
    <link rel="stylesheet" href="../static/MDUI_files/style.css">
    <script src="https://hm.baidu.com/hm.js?33d719afc3e48d8a2fbdd886b164d2e4"></script>
    <script>
        var _hmt = _hmt || [];
        (function () {
            var hm = document.createElement("script");
            hm.src = "https://hm.baidu.com/hm.js?33d719afc3e48d8a2fbdd886b164d2e4";
            var s = document.getElementsByTagName("script")[0];
            s.parentNode.insertBefore(hm, s);
        })();
    </script>
    <style></style>
    <style id="style-1-cropbar-clipper">/* Copyright 2014 Evernote Corporation. All rights reserved. */
    .en-markup-crop-options {
        top: 18px !important;
        left: 50% !important;
        margin-left: -100px !important;
        width: 200px !important;
        border: 2px rgba(255, 255, 255, .38) solid !important;
        border-radius: 4px !important;
    }

    .en-markup-crop-options div div:first-of-type {
        margin-left: 0px !important;
    }
    </style>
</head>
<body class="mdui-theme-primary-indigo mdui-theme-accent-pink mdui-loaded" style="">

<!-- 首屏 -->
<div class="main-section mdui-color-theme">
    <div class="mdui-container main-container">
        <h2>
            <br>
            <span class="mdui-text-color-theme-accent"></span>Hotel <span class="mdui-text-color-theme-accent"></span>Management
            <span class="mdui-text-color-theme-accent"></span>System
        </h2>

        <h4>酒店信息管理系统</h4>

        <div class="main-btn-wrapper">
            <a href="go?url=ManagerLogin" class="mdui-btn main-btn mdui-ripple mdui-ripple-white mdui-m-r-2">经理登录</a>
            <a href="go?url=ReceptionistLogin" class="mdui-btn main-btn mdui-ripple mdui-ripple-white mdui-m-r-2">接待员登录</a>
            <a href="go?url=CustomerLogin" class="mdui-btn main-btn mdui-ripple mdui-ripple-white">客户登录</a>
            <%--<a href="go?url=basicSetting/test" class="mdui-btn main-btn mdui-ripple mdui-ripple-white">test</a>--%>
        </div>
    </div>
</div>

<script src="../static/MDUI_files/mdui.min.js"></script>
<script>
    var $$ = mdui.JQ;

    $$(function () {
        // appbar 自动隐藏
        var $appbar = $$('.mdui-appbar');
        $$(window).on('scroll', function () {
            $appbar[document.body.scrollTop === 0 ? 'addClass' : 'removeClass']('mdui-shadow-0');
        });
    });

</script>
</body>
</html>