<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>

<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/system/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/system/data.js"></script>
<div id="data-tool-bar" style="padding: 10px">
    <a href="#" class="easyui-menubutton" menu="#save-data-btn" data-options="iconCls:'icon-add'"
       style="width:70px">新增</a>
    <a href="#" class="easyui-linkbutton" id="update-data" data-options="iconCls:'icon-edit'" style="width:70px">修改</a>
    <a href="#" class="easyui-linkbutton" id="delete-data" data-options="iconCls:'icon-remove'"
       style="width:70px">删除</a>
    <a href="#" class="easyui-linkbutton" id="flash-data" data-options="iconCls:'icon-reload'" style="width:70px">刷新</a>
</div>
<div id="data_grid" style="padding: 10px">

</div>
<div id="save-data-btn">
    <div data-options="iconCls:'icon-add' " id="save-data-data" style="width:70px">字典</div>
    <div data-options="iconCls:'icon-add'" id="save-data-group" style="width:70px">字典组</div>
</div>

<div id="save-data-dialog">

    <form action="#" id="save-data-form">
        <input type="hidden" id="id" name="id">
        <div style="float: left;height: 300px;">
            <p style="padding: 10px;">&nbsp;&nbsp;名称:<input name="data_keyName" id="data_keyName"
                                                            style="width: 300px;height: 35px"
                                                            data-options="required:true"
                                                            class="easyui-textbox easyui-validatebox"></p>
            <p style="padding: 10px ;">&nbsp;&nbsp;&nbsp;值:<input name="data_keyValue" id="data_keyValue"
                                                                  style="width: 300px;height: 35px"
                                                                  data-options="required:true"
                                                                  class="easyui-textbox easyui-validatebox"></p>
            <p style="padding: 10px;"> &nbsp;&nbsp;描述:<input name="data_description" id="data_description"
                                                             style="width: 300px;height: 130px"
                                                             data-options="required:true,multiline:true"
                                                             class="easyui-textbox easyui-validatebox">
            </p>
        </div>
        <div style="float: right; width: 40%; height:326px;">
            <table class="easyui-datagrid" id="data-group" data-options="
                   url:'${pageContext.request.contextPath}/system/dataGroup/list',
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
                    <th data-options="field:'name',width:200">字典组名称</th>
                </tr>
                </thead>
            </table>
        </div>
    </form>
</div>
</div>

<div id="save-data-group-dialog">
    <div>
        <form id="save-data-group-form" style="padding: 10px;">
            <div style="float: left;">
                <p style="padding: 10px;">&nbsp;&nbsp;名称:<input name="data_name" id="data_group_name"
                                                                style="width: 300px;height: 35px"
                                                                data-options="required:true"
                                                                class="easyui-textbox easyui-validatebox"></p>
                <p style="padding: 10px;"> &nbsp;&nbsp;描述:<input name="data_description" id="data_group_description"
                                                                 style="width: 300px;height: 130px"
                                                                 data-options="required:true,multiline:true"
                                                                 class="easyui-textbox easyui-validatebox">
                </p>
            </div>
        </form>
    </div>
</div>

