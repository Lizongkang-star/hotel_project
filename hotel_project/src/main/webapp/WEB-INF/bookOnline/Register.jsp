<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="renderer" content="webkit">
    <meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=no">
    <title></title>
    <link rel="stylesheet" href="../../static/MDUI_files/mdui.min.css">
    <link rel="stylesheet" href="../../static/MDUI_files/style.css">
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

    <style id="style-1-cropbar-clipper">/* Copyright 2014 Evernote Corporation. All rights reserved. */

    .en-markup-crop-options div div:first-of-type {
        margin-left: 0 !important;
    }
    </style>
</head>
<body class="mdui-theme-primary-indigo mdui-theme-accent-pink mdui-loaded" style="">

<!-- 首屏 -->
<div class="main-section mdui-color-theme" style="display: flex;flex-direction: column;">
    <div class="mdui-container main-container" style="display: flex;flex-direction: column;justify-content: center;">
        <h2>
            <br>
            客户注册
        </h2>
        <div class="mdui-center" style="width: 500px;">
            <table style="justify-content: center;margin-left: auto;margin-right: auto;">
                <form action="userRegister" method="post">
                    <div class="mdui-textfield">
                        用户名<input type="text" pattern="^[a-zA-Z][a-zA-Z0-9]{3,15}$" class="mdui-textfield-input"
                                  name="username" placeholder="用户名由英文字母和数字组成的4-16位字符，以字母开头" required/>
                        <div class="mdui-textfield-error">用户名格式错误</div>
                    </div>
                    <div class="mdui-textfield">
                        密码<input type="password" pattern="^[a-zA-Z0-9]{4,10}$" class="mdui-textfield-input"
                                 name="password" placeholder="密码由英文字母和数字组成的4-10位字符" required/>
                        <div class="mdui-textfield-error">密码格式错误</div>
                    </div>

                    <tr>
                        <div class="mdui-textfield">
                            姓名<textarea class="mdui-textfield-input" name="realname" placeholder="姓名"
                                        required></textarea>
                        </div>

                    <tr>
                    <tr>
                        <div class="mdui-textfield">
                            手机号码<input class="mdui-textfield-input" name="phone" type="text"
                                       pattern="^1([38][0-9]|4[579]|5[0-3,5-9]|6[6]|7[0135678]|9[89])\d{8}$"
                                       placeholder="电话号码" required/>
                            <div class="mdui-textfield-error">手机号格式不正确</div>
                        </div>

                    <tr>
                        <div class="mdui-textfield">
                            性别
                            <div class="mdui-radio">
                                <label class="mdui-radio">
                                    <input type="radio" name="gender" value="male"/>
                                    <i class="mdui-radio-icon"></i>
                                    男
                                </label>
                                <label class="mdui-radio">
                                    <input type="radio" name="gender" value="female"/>
                                    <i class="mdui-radio-icon"></i>
                                    女
                                </label>
                            </div>
                        </div>
                    </tr>
                    <div class="mdui-textfield">
                        身份证号码
                        <input class="mdui-textfield-input" type="text" pattern="(^\d{15}$)|(^\d{17}([0-9]|X)$)"
                               name="idcard" placeholder="身份证号码" required/>
                        <div class="mdui-textfield-error">身份证格式错误</div>
                    </div>
                    </tr>

                    <tr>
                        <td>
                            <button class="mdui-btn mdui-btn-raised mdui-ripple mdui-color-theme-accent"
                                    style="justify-content: center;margin-left: auto;margin-right: auto;width: 200px;">
                                注册
                            </button>
                        </td>
                </form>
                </tr>
            </table>
        </div>
        <br>
    </div>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
</div>

<script src="../../static/MDUI_files/mdui.min.js"></script>
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


