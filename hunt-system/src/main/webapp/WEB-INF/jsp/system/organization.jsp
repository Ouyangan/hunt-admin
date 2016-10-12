<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<script type="text/javascript" src="/static/js/system/organization.js"></script>
<div id="tool-bar" style="padding: 10px">
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'" style="width:70px">新增</a>
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove'" style="width:70px">修改</a>
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save'" style="width:70px">删除</a>

        Date From: <input class="easyui-datebox" style="width:80px">
        To: <input class="easyui-datebox" style="width:80px">
        Language:
        <select class="easyui-combobox" panelHeight="auto" style="width:100px">
            <option value="java">Java</option>
            <option value="c">C</option>
            <option value="basic">Basic</option>
            <option value="perl">Perl</option>
            <option value="python">Python</option>
        </select>
        <a href="#" class="easyui-linkbutton" iconCls="icon-search">Search</a>
</div>
<div id="organization" style="padding: 10px">

</div>

