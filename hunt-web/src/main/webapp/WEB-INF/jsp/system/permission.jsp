<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>

<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/system/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/system/permission.js"></script>
<div id="permission-tool-bar" style="padding: 10px">
    <div href="#" class="easyui-menubutton" menu="#save-permission-btn" data-options="iconCls:'icon-add'"
         style="width:70px">新增
    </div>
    <div href="#" class="easyui-linkbutton" id="flash-permission" data-options="iconCls:'icon-reload'"
         style="width:70px">刷新
    </div>
    <div href="#" class="easyui-linkbutton" id="update-permission" data-options="iconCls:'icon-edit'"
         style="width:70px">修改
    </div>
    <div href="#" class="easyui-linkbutton" id="delete-permission" data-options="iconCls:'icon-remove'"
         style="width:70px">删除
    </div>
</div>
<div id="permission_grid" style="padding: 10px">

</div>
<div id="save-permission-btn">
    <div data-options="iconCls:'icon-add' " id="save-permission-permission" style="width:70px">权限</div>
    <div data-options="iconCls:'icon-add'" id="save-permission-group" style="width:70px">权限组</div>
</div>

<div id="save-permission-dialog">

    <form action="#" id="save-permission-form">
        <input type="hidden" id="id" name="id">
        <div style="float: left;height: 300px;">
            <p style="padding: 10px;">&nbsp;&nbsp;名称:<input name="permission_name" id="permission_name"
                                                            style="width: 300px;height: 35px"
                                                            data-options="required:true"
                                                            class="easyui-textbox easyui-validatebox"></p>
            <p style="padding: 10px ;">&nbsp;&nbsp;编码:<input name="permission_code" id="permission_code"
                                                             style="width: 300px;height: 35px"
                                                             data-options="required:true"
                                                             class="easyui-textbox easyui-validatebox"></p>
            <p style="padding: 10px;"> &nbsp;&nbsp;描述:<input name="permission_description" id="permission_description"
                                                             style="width: 300px;height: 130px"
                                                             data-options="required:true,multiline:true"
                                                             class="easyui-textbox easyui-validatebox">
            </p>
        </div>
        <div style="float: right; width: 40%; height:326px;">
            <table class="easyui-datagrid" id="permission-group" data-options="
                   url:'${pageContext.request.contextPath}/permission/group/list',
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
                <p style="padding: 10px;">&nbsp;&nbsp;名称:<input name="permission_group_name" id="permission_group_name"
                                                                style="width: 300px;height: 35px"
                                                                data-options="required:true"
                                                                class="easyui-textbox easyui-validatebox"></p>
                <p style="padding: 10px;"> &nbsp;&nbsp;描述:<input name="permission_group_description"
                                                                 id="permission_group_description"
                                                                 style="width: 300px;height: 130px"
                                                                 data-options="required:true,multiline:true"
                                                                 class="easyui-textbox easyui-validatebox">
                </p>
            </div>
        </form>
    </div>
</div>

