<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<%@include file="DrawerBar.html" %>

<div>
    <p>后续功能，敬请期待</p>
</div>

<script src="../../static/MDUI_files/mdui.min.js"></script>
<script type="text/javascript">
    //p for parent bar
    var p = document.getElementById("RoomPreservationManagement");
    var open = "mdui-collapse-item mdui-collapse-item-open";
    p.setAttribute("class", open);
    //c for child bar
    var c = document.getElementById("GroupBook");
    var active = "mdui-list-item mdui-ripple mdui-list-item-active";
    c.setAttribute('class', active);
</script>

<script type="text/javascript">
    var $$ = mdui.JQ;

    $$(function () {
        // appbar 自动隐藏
        var $appbar = $$('.mdui-appbar');
        $$(window).on('scroll', function () {
            $appbar[document.body.scrollTop === 0 ? 'addClass' : 'removeClass']('mdui-shadow-0');
        });
    });
</script>