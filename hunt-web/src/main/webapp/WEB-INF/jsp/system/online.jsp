<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>


<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/system/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/system/online.js"></script>
<div id="online-tool-bar" style="padding: 10px">
    <div class="easyui-linkbutton " id="online-logout-btn" data-options="iconCls:'icon-add'" style="width:85px">强制下线
    </div>
    <div class="easyui-linkbutton " id="online-flash-btn" data-options="iconCls:'icon-reload'" style="width:85px">刷新页面
    </div>
    登陆名:<input id="login_name" class="textbox" style="height: 22px;">
    中文名:<input id="zh_name" class="textbox" style="height: 22px;">
    <div class="easyui-linkbutton " id="online-select-btn" data-options="iconCls:'icon-add'" style="width:60px">查询
    </div>
</div>
<div id="online_grid" style="padding: 10px">

</div>