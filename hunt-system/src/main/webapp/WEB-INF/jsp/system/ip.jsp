<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>

<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/system/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/system/ip.js"></script>
<div id="ip-tool-bar" style="padding: 10px">
    <strong>拦截开关:</strong>
    <div class="easyui-switchbutton  " id="ip-switchButton-btn" style="width:70px">
    </div>
    <div class="easyui-linkbutton  " id="ip-select-btn" data-options="iconCls:'icon-reload'" style="width:70px">刷新
    </div>
    <div class="easyui-linkbutton " id="ip-save-btn" data-options="iconCls:'icon-add'" style="width:70px">新增</div>
    <div class="easyui-linkbutton " id="ip-update-btn" data-options="iconCls:'icon-edit'" style="width:70px">修改</div>
    <div class="easyui-linkbutton " id="ip-delete-btn" data-options="iconCls:'icon-remove'" style="width:70px">删除</div>
</div>
<div id="ip_grid" style="padding: 10px">

</div>

<div id="ip_dialog">
    <form id="ip_form">
        <input type="hidden" name="id" id="ip-id">
        <div style="float: left;height: 100%;">
            <p style="padding: 10px;">&nbsp;&nbsp;&nbsp;IP:<input name="ip" id="ip-name"
                                                                  style="width: 300px;height: 35px"
                                                                  data-options="required:true"
                                                                  class="easyui-textbox easyui-validatebox"></p>
            <p style="padding: 10px ;">到期时间:<input name="expireTime" id="ip-expireTime"
                                                   style="width: 300px;height: 35px"
                                                   data-options="required:true"
                                                   class="easyui-datetimebox"></p>
            <p style="padding: 10px;"> &nbsp;&nbsp;描述:<input name="description" id="ip-description"
                                                             style="width: 300px;height: 130px"
                                                             data-options="required:true,multiline:true"
                                                             class="easyui-textbox easyui-validatebox">
            </p>
        </div>
    </form>
</div>
</div>
