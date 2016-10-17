<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<script type="text/javascript" src="/static/js/system/permission.js"></script>
<script type="text/javascript" src="/static/js/system/common.js"></script>
<div id="permission-tool-bar" style="padding: 10px">
    <a href="#" class="easyui-menubutton" menu="#save" data-options="iconCls:'icon-add'" style="width:70px">新增</a>
    <a href="#" class="easyui-linkbutton" id="update-permission" data-options="iconCls:'icon-edit'" style="width:70px">修改</a>
    <a href="#" class="easyui-linkbutton" id="delete-permission" data-options="iconCls:'icon-remove'"
       style="width:70px">删除</a>
    <a href="#" class="easyui-linkbutton" id="flash-permission" data-options="iconCls:'icon-reload'" style="width:70px">刷新</a>
</div>
<div id="permission_grid" style="padding: 10px">

</div>
<div id="save">
    <div data-options="iconCls:'icon-add' " id="save-permission" style="width:70px">权限</div>
    <div data-options="iconCls:'icon-add'" id="save-permissionGroup" style="width:70px">权限组</div>
</div>

<div id="save-permission-dialog">

    <form action="#" id="save-permission-form">
        <input type="hidden" id="id" name="id">
        <div style="float: left;height: 300px;">
            <p style="padding: 10px;">&nbsp;&nbsp;名称:<input name="name" id="name" style="width: 300px;height: 35px"
                                                            data-options="required:true"
                                                            class="easyui-textbox easyui-validatebox"></p>
            <p style="padding: 10px ;">&nbsp;&nbsp;编码:<input name="code" id="code"
                                                             style="width: 300px;height: 35px"
                                                             data-options="required:true"
                                                             class="easyui-textbox easyui-validatebox"></p>
            <p style="padding: 10px;"> &nbsp;&nbsp;描述:<input name="description" id="description"
                                                             style="width: 300px;height: 130px"
                                                             data-options="required:true,multiline:true"
                                                             class="easyui-textbox easyui-validatebox">
            </p>
        </div>
        <div style="float: right; width: 40%; height:326px;">
            <table  class="easyui-datagrid" id="permission-group" data-options="
                   url:'/permission/selectGroup',
                   idField: 'id',
                   method:'get',
                   fitColumns:true,
                   fit:true,
                   singleSelect:true,
                ">
                <thead frozen="true">
                <tr>
                    <th data-options="field:'ck', checkbox: true">选择</th>
                </tr>
                </thead>
                <thead>
                <tr>
                    <th data-options="field:'name',width:200">权限组名称</th>
                </tr>
                </thead>
            </table>
        </div>
    </form>
</div>
</div>

<div id="save-permission-group-dialog">
    <div>
        <form action="#" id="save-permission-group-form" style="padding: 10px;">
            <div style="float: left;">
                <p style="padding: 10px;">&nbsp;&nbsp;名称:<input name="name" id="group_name"
                                                                style="width: 300px;height: 35px"
                                                                data-options="required:true"
                                                                class="easyui-textbox easyui-validatebox"></p>
                <p style="padding: 10px;"> &nbsp;&nbsp;描述:<input name="description" id="group_description"
                                                                 style="width: 300px;height: 130px"
                                                                 data-options="required:true,multiline:true"
                                                                 class="easyui-textbox easyui-validatebox">
                </p>
            </div>
        </form>
    </div>
</div>

