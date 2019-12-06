<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<%@include file="DrawerBar.html" %>

<html>
<body>
<h1>
    body1
</h1>
</body>
</html>


<html>
<body>
<h1>
    body2
</h1>
<select class="mdui-select" id="demo-js">
    <option value="1">State 1</option>
    <option value="2">State 2</option>
    <option value="3" disabled>State 3</option>
    <option value="4">State 4</option>
    <option value="5">State 5</option>
    <option value="6">State 6</option>
</select>

</body>
</html>
<script src="../../static/MDUI_files/mdui.min.js"></script>
<script type="text/javascript">
    var BasicSetting = document.getElementById("BasicSetting");
    var open = "mdui-collapse-item mdui-collapse-item-open";
    BasicSetting.setAttribute("class", open);

    var RoomTypeSetting = document.getElementById("RoomTypeSetting");
    var active = "mdui-list-item mdui-ripple mdui-list-item-active";
    RoomTypeSetting.setAttribute('class', active);
</script>

<script>
    var inst = new mdui.Select('#demo-js');
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
</body></html>

