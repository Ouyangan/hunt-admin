<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<script type="text/javascript" src="/static/js/system/role.js"></script>
<script type="text/javascript" src="/static/js/system/common.js"></script>
<div id="role-tool-bar" style="padding: 10px">
    <a href="#" class="easyui-linkbutton role-save-btn" data-options="iconCls:'icon-add'" style="width:70px">新增</a>
    <a href="#" class="easyui-linkbutton role-update-btn" data-options="iconCls:'icon-edit'" style="width:70px">修改</a>
    <a href="#" class="easyui-linkbutton role-delete-btn" data-options="iconCls:'icon-remove'" style="width:70px">删除</a>
    <a href="#" class="easyui-linkbutton role-select-btn " data-options="iconCls:'icon-reload'" style="width:70px">刷新</a>
</div>
<div id="role_grid" style="padding: 10px">

</div>

<div id="role_edit">
    <form id="role_edit_form">
        <input type="hidden" name="id" id="id">
        <p style="padding: 10px;">&nbsp;&nbsp;简称:<input name="name" id="name"
                                                        style="width: 300px;height: 35px"
                                                        data-options="required:true"
                                                        class="easyui-textbox easyui-validatebox"></p>
        <p style="padding: 10px;"> &nbsp;&nbsp;描述:<input name="description" id="description"
                                                         style="width: 300px;height: 130px"
                                                         data-options="required:true"
                                                         class="easyui-textbox easyui-validatebox">

    </form>
</div>