<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>

<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/system/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/system/job.js"></script>

<div id="job-tool-bar" style="padding: 10px">
    <div class="easyui-linkbutton  " id="job-select-btn" data-options="iconCls:'icon-reload'" style="width:70px">刷新
    </div>
    <div class="easyui-linkbutton " id="job-save-btn" data-options="iconCls:'icon-add'" style="width:70px">新增</div>
    <div class="easyui-linkbutton " id="job-update-btn" data-options="iconCls:'icon-edit'" style="width:70px">修改</div>
    <div class="easyui-linkbutton " id="job-delete-btn" data-options="iconCls:'icon-remove'" style="width:70px">删除</div>
</div>
<div id="job_grid" style="padding: 10px">

</div>

<div id="job_dialog">
    <form id="job_form">
        <input type="hidden" name="id" id="id">
        <div style="float: left;height: 290px;">
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
        <div style="float: right;width: 300px;;height: 100%;">
            <table id="job_dialog_parent_tree" class="easyui-treegrid"
                   data-options="
                url:'${pageContext.request.contextPath}/job/list',
                method:'get',
                idField: 'id',
                nodeId:'id',
                treeField: 'name',
                border: true,
                rownumbers: true,
                fit: true,
                fitColumns: false,
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
                    <th data-options="field:'name',width:260">上级职位</th>
                </tr>
                </thead>
            </table>
        </div>
        <div style="float: right;width: 200px;height: 100%">
            <table id="job_dialog_role" class="easyui-datagrid"
                   data-options="
                url:'${pageContext.request.contextPath}/role/list',
                method:'get',
                idField: 'id',
                nodeId:'id',
                treeField: 'name',
                border: true,
                rownumbers: true,
                fit: true,
                fitColumns: false,
                checkOnSelect:true,
                singleSelect:true,
                required:true,
            ">
                <thead frozen="true">
                <tr>
                    <th data-options="field:'ck', checkbox: true">选择</th>
                </tr>
                </thead>
                <thead>
                <tr>
                    <th data-options="field:'name',width:260">系统角色</th>
                </tr>
                </thead>
            </table>
        </div>
        <div style="float: right;width: 300px;height: 100%">
            <table id="job_dialog_organization" class="easyui-treegrid"
                   data-options="
                url:'${pageContext.request.contextPath}/organization/list',
                method:'get',
                idField: 'id',
                nodeId:'id',
                treeField: 'name',
                border: true,
                rownumbers: true,
                fit: true,
                fitColumns: false,
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
                    <th data-options="field:'name',width:260">组织机构</th>
                </tr>
                </thead>
            </table>
        </div>
    </form>
</div>
</div>
