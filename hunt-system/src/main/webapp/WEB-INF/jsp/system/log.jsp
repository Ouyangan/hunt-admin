<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>


<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/system/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/system/log.js"></script>
<div id="log-tool-bar" style="padding: 10px 10px 0 10px">
    <form id="select_form">
        <div class="easyui-linkbutton " id="log-flash-btn" data-options="iconCls:'icon-reload'" style="width:70px">刷新
        </div>
        <span style="line-height: 26px; ">method:<input name="method" class="easyui-textbox"
                                                        style="line-height: 26px; "></span>
        <span style="line-height: 26px; ">url:<input name="url" class="easyui-textbox"
                                                     style="line-height: 26px; "></span>
        <span style="line-height: 26px; ">param:<input name="param" class="easyui-textbox" style="line-height: 26px; "></span>
        <span style="line-height: 26px; ">result:<input name="result" class="easyui-textbox"
                                                        style="line-height: 26px; "></span>&nbsp;
        <div class="easyui-linkbutton " id="log-select-btn" data-options="iconCls:'icon-search'" style="width:70px">搜索
        </div>
    </form>
</div>
<div id="log_grid" style="padding: 10px">

</div>