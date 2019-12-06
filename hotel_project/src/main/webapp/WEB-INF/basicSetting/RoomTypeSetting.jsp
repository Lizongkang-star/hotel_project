<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!DOCTYPE html>
<%@include file="DrawerBar.html" %>

<div class="mdui-container main-container mdui-text-left">
    <h1>
        请输入要设置的房间类型信息
    </h1>
    <form action="RoomTypeSetting" method="post">
        <div class="mdui-textfield mdui-textfield-floating-label">
            <label class="mdui-textfield-label">类型名称</label>
            <input type="text" class="mdui-textfield-input" size="10" name="NameOfCategory" required/>
        </div>
        <div class="mdui-textfield mdui-textfield-floating-label">
            <label class="mdui-textfield-label">价格（元/天）</label>
            <input type="number" min="1" class="mdui-textfield-input" size="10" name="PriceOfCategory" required/>
        </div>
        <div class="mdui-textfield mdui-textfield-floating-label">
            <label class="mdui-textfield-label">总量（间）</label>
            <input type="number" min="1" class="mdui-textfield-input" size="10" name="totalNumberOfCategory" required/>
        </div>
        <div class="mdui-textfield mdui-textfield-floating-label">
            <label class="mdui-textfield-label">评分（10分制）</label>
            <input type="number" min="1" max="10" class="mdui-textfield-input" size="10" name="scoreOfCategory"
                   required/>
        </div>
        <button type="submit" class="mdui-btn mdui-btn-raised mdui-ripple mdui-color-theme-accent">提交</button>
    </form>
</div>


<script src="../../static/MDUI_files/mdui.min.js"></script>
<script type="text/javascript">
    var BasicSetting = document.getElementById("BasicSetting");
    var open = "mdui-collapse-item mdui-collapse-item-open";
    BasicSetting.setAttribute("class", open);

    var RoomTypeSetting = document.getElementById("RoomTypeSetting");
    var active = "mdui-list-item mdui-ripple mdui-list-item-active";
    RoomTypeSetting.setAttribute('class', active);
</script>