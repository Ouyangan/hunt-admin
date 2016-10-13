<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<script type="text/javascript" src="/static/js/system/organization.js"></script>
<script type="text/javascript" src="/static/js/system/common.js"></script>
<div id="tool-bar" style="padding: 10px">
    <a href="#" class="easyui-linkbutton save-btn" data-options="iconCls:'icon-add'" style="width:70px">新增</a>
    <a href="#" class="easyui-linkbutton update-btn" data-options="iconCls:'icon-edit'" style="width:70px">修改</a>
    <a href="#" class="easyui-linkbutton delete-btn" data-options="iconCls:'icon-remove'" style="width:70px">删除</a>
    <a href="#" class="easyui-linkbutton select-btn " data-options="iconCls:'icon-reload'" style="width:70px">刷新</a>
</div>
<div id="organization" style="padding: 10px">

</div>

<div id="organization_save" >
    <div>
        <div id="organization_save_left" style="float: left;height: 300px;">
            <p style="padding: 10px;">&nbsp;&nbsp;简称:<input name="name" id="name" style="width: 300px;height: 35px"
                                                            data-options="required:true"
                                                            class="easyui-textbox easyui-validatebox"></p>
            <p style="padding: 10px ;">&nbsp;&nbsp;全称:<input name="fullName" id="fullName"
                                                             style="width: 300px;height: 35px"
                                                             data-options="required:true"
                                                             class="easyui-textbox easyui-validatebox"></p>
            <p style="padding: 10px;"> &nbsp;&nbsp;描述:<input name="description" id="description"
                                                             style="width: 300px;height: 130px"
                                                             data-options="required:true,multiline:true"
                                                             class="easyui-textbox easyui-validatebox">
            </p>
        </div>
        <div style="float: right;width:50%;height: 400px;">
            <table id="organization_save_right" class="easyui-treegrid easyui-validatebox"
                   data-options="
                idField: 'id',
                treeField: 'name',
                border: false,
                rownumbers: true,
                fit: true,
                fitColumns: true,
                checkOnSelect:true,
                required:true,
            ">
                <thead frozen="true">
                <tr>
                    <th data-options="field:'ck', checkbox: true">选择</th>
                </tr>
                </thead>
                <thead>
                <tr>
                    <th data-options="field:'name'">组织名称</th>
                </tr>
                </thead>
            </table>
        </div>
    </div>
</div>
