<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<script type="text/javascript" src="/static/js/system/user.js"></script>
<script type="text/javascript" src="/static/js/system/common.js"></script>
<div id="user-tool-bar" style="padding: 10px">
    <div class="easyui-linkbutton " id="user-save-btn" data-options="iconCls:'icon-add'" style="width:70px">新增</div>
    <div class="easyui-linkbutton " id="user-update-btn" data-options="iconCls:'icon-edit'" style="width:70px">修改</div>
    <div class="easyui-linkbutton " id="user-detail-btn" data-options="iconCls:'icon-edit'" style="width:70px">查看详情
    </div>
    <div class="easyui-linkbutton " id="user-delete-btn" data-options="iconCls:'icon-remove'" style="width:70px">删除
    </div>
    <div class="easyui-linkbutton " id="user-flash-btn" data-options="iconCls:'icon-reload'" style="width:70px">刷新
    </div>
</div>
<div id="user_grid" style="padding: 10px">

</div>
<div id="user_edit_dialog">
    <form action="#" id="user_edit_form">

    </form>
</div>