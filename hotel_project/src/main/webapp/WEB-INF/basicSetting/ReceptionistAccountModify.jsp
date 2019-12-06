<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<%@include file="DrawerBar.html" %>
<!-- Content-->
<div class="mdui-container doc-container main-section" style="display: flex;flex-direction: column;">
    <%--<div class="mdui-container doc-container main-section mdui-color-theme" style="display: flex;flex-direction: column;">--%>
    <div class="mdui-container main-container" style="display: flex;flex-direction: column;justify-content: center;">
        <h1>
            接待员账号修改
        </h1>
        请选择要修改的接待员账号ID:
        <form action="adminAccountUpdateID" method="post">
            接待员账号ID:
            <select class="mdui-select" id="roomTypeSelect" name="modifyReceptionistID">
                <c:forEach var="receptionistID" items="${sessionScope.AllReceptionistID}"
                           varStatus="status">
                    <option>${receptionistID}</option>
                </c:forEach>
            </select>

            <button type="submit" class="mdui-btn mdui-btn-raised mdui-ripple mdui-color-theme-accent">提交</button>
        </form>
        <br>
    </div>

</div>

<script src="../../static/MDUI_files/mdui.min.js"></script>
<script type="text/javascript">
    //p for parent bar
    var p = document.getElementById("AccountSetting");
    var open = "mdui-collapse-item mdui-collapse-item-open";
    p.setAttribute("class", open);
    //c for child bar
    var c = document.getElementById("ReceptionistSetting");
    var active = "mdui-list-item mdui-ripple mdui-list-item-active";
    c.setAttribute('class', active);
</script>

</body></html>

