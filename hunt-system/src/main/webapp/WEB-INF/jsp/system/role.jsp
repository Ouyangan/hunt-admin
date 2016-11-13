<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/system/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/system/role.js"></script>
<div id="role-tool-bar" style="padding: 10px">
    <div class="easyui-linkbutton " id="role-select-btn" data-options="iconCls:'icon-reload'" style="width:70px">刷新
    </div>
    <div class="easyui-linkbutton " id="role-save-btn" data-options="iconCls:'icon-add'" style="width:70px">新增</div>
    <div class="easyui-linkbutton " id="role-update-btn" data-options="iconCls:'icon-edit'" style="width:70px">修改</div>
    <div class="easyui-linkbutton " id="role-delete-btn" data-options="iconCls:'icon-remove'" style="width:70px">删除
    </div>

</div>
<div id="role_grid" style="padding: 10px">

</div>

<div id="role_edit_dialog">
    <form id="role_edit_form">
        <div style="float: left;padding: 15px;">
            <input type="hidden" name="id" id="id">
            <p style="padding: 5px">&nbsp;&nbsp;名称:<input name="name" id="name"
                                                          style="width: 300px;height: 35px"
                                                          data-options="required:true"
                                                          class="easyui-textbox easyui-validatebox"></p>
            <p style="padding: 5px;"> &nbsp;&nbsp;描述:<input name="description" id="description"
                                                            style="width: 300px;height: 130px"
                                                            data-options="required:true,multiline:true"
                                                            class="easyui-textbox easyui-validatebox">
        </div>
        <div style="float: right; width: 50%;height: 100%;">
            <table id="role-permissions" class="easyui-datagrid" data-options="
                url:'${pageContext.request.contextPath}/permission/list',
                method:'get',
                idField:'id',
                view:groupview,
                groupField:'sysPermissionGroupId',
                groupFormatter: function (value, rows) {
                return rows[0].sysPermissionGroupName;
                },
                fitColumns: true,
                rownumbers: true,
                fit: true,
                ">
                <thead frozen="true">
                <tr>
                    <th data-options="field:'ck', checkbox: true">选择</th>
                </tr>
                </thead>
                <thead>
                <tr>
                    <th data-options="field:'name',width:200">权限名称</th>
                </tr>
                </thead>
            </table>
        </div>
    </form>
</div>