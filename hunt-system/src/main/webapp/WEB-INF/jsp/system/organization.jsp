<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<script type="text/javascript" src="/static/js/system/organization.js"></script>
<div id="tool-bar" style="padding: 10px">
    <a href="#" class="easyui-linkbutton save-btn" data-options="iconCls:'icon-add'" style="width:70px">新增</a>
    <a href="#" class="easyui-linkbutton update-btn" data-options="iconCls:'icon-edit'" style="width:70px">修改</a>
    <a href="#" class="easyui-linkbutton delete-btn" data-options="iconCls:'icon-remove'" style="width:70px">删除</a>
    <a href="#" class="easyui-linkbutton select-btn " data-options="iconCls:'icon-reload'" style="width:70px">刷新</a>
    <%--Date From: <input class="easyui-datebox" style="width:80px">--%>
    <%--To: <input class="easyui-datebox" style="width:80px">--%>
    <%--Language:--%>
    <%--<select class="easyui-combobox" panelHeight="auto" style="width:100px">--%>
    <%--<option value="java">Java</option>--%>
    <%--<option value="c">C</option>--%>
    <%--<option value="basic">Basic</option>--%>
    <%--<option value="perl">Perl</option>--%>
    <%--<option value="python">Python</option>--%>
    <%--</select>--%>
    <%--<a href="#" class="easyui-linkbutton" iconCls="icon-search">Search</a>--%>

</div>
<div id="organization" style="padding: 10px">

</div>

<div id="organization-save" style="padding: 10px">
    <div>
        <p>简称:<input name="name" id="name" style="width: 300px;height: 35px" data-options="required:true"
                     class="easyui-textbox easyui-validatebox">
        <p>全称:<input name="fullName" id="fullName" style="width: 300px;height: 35px" data-options="required:true"
                     class="easyui-textbox easyui-validatebox"></p>
        <p>描述:<input name="description" id="description" style="width: 300px;height: 100px"
                     data-options="required:true,multiline:true" class="easyui-textbox easyui-validatebox"></p>
    </div>
    <div>

    </div>
</div>
