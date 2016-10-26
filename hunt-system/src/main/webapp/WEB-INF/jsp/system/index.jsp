<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>hun-admin</title>
    <link type="image/x-icon" rel="shortcut icon" href="/static/image/favicon.ico">
    <link type="image/x-icon" rel="bookmark" href="/static/image/favicon.ico">
    <link rel="stylesheet" type="text/css" href="/static/css/easyui.css"/>
    <link rel="stylesheet" type="text/css" href="/static/css/icon.css"/>
    <link rel="stylesheet" type="text/css" href="/static/css/system/index.css"/>
    <script type="text/javascript" src="/static/js/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="/static/js/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="/static/js/easyui/datagrid-groupview.js"></script>
    <script type="text/javascript" src="/static/js/easyui/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="/static/js/system/index.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body class="easyui-layout">
<div data-options="region:'north',border:false" style="height:40px; background:#198ec2;padding: 0;">
    <div style="height: 40px; float: left; line-height: 40px">
        <span style="font-weight:bolder; font-size: large;padding-left: 10px;color: #ffffff">Hunt-Admin 快速开发平台</span>
    </div>
    <div style="float:right;height: 40px;padding: 0 5px;">
        <input id="logout-btn" class="easyui-linkbutton logout" value="安全退出">
    </div>
</div>
<div data-options="region:'west',border:true,split:true" style="text-align: center;width:200px;">
    <div class="easyui-accordion" data-options="border:false,fit:true,">
        <div title="系统管理">
            <ul style="list-style: none;padding: 0 0 0 0 ;">
                <div style="padding: 5px 10px;">
                    <li class="nav-list">
                        <div class="easyui-linkbutton" data-options="iconCls:'icon-reload'" style="border: 0;"
                             href="/user/user">用户管理
                        </div>
                    </li>
                </div>

                <div style="padding: 5px 10px;">
                    <li class="nav-list">
                        <div class="easyui-linkbutton" data-options="iconCls:'icon-reload'" style="border: 0; "
                             href="/job/job">职位管理
                        </div>
                    </li>
                </div>
                <div style="padding: 5px 10px;">
                    <li class="nav-list">
                        <div class="easyui-linkbutton" data-options="iconCls:'icon-reload'" style="border: 0;"
                             href="/organization/organization">机构管理
                        </div>
                    </li>
                </div>
                <div style="padding: 5px 10px;">
                    <li class="nav-list">
                        <div class="easyui-linkbutton" data-options="iconCls:'icon-reload'"
                             style="border: 0;background: #ffffff; "
                             href="/role/role">角色管理
                        </div>
                    </li>
                </div>

                <div style="padding: 5px 10px;">
                    <li class="nav-list">
                        <div class="easyui-linkbutton" data-options="iconCls:'icon-reload'" style="border: 0;"
                             href="/permission/permission">权限管理
                        </div>
                    </li>
                </div>
                <div style="padding: 5px 10px;">
                    <li class="nav-list">
                        <div class="easyui-linkbutton" data-options="iconCls:'icon-reload'" style="border: 0;"
                             href="/system/data">字典管理
                        </div>
                    </li>
                </div>
                <div style="padding: 5px 10px;">
                    <li class="nav-list">
                        <div class="easyui-linkbutton" data-options="iconCls:'icon-reload'" style="border: 0;"
                             href="/system/online">在线状态
                        </div>
                    </li>
                </div>
                <div style="padding: 5px 10px;">
                    <li class="nav-list">
                        <div class="easyui-linkbutton" data-options="iconCls:'icon-reload'" style="border: 0;"
                             href="/system/log">系统日志
                        </div>
                    </li>
                </div>
                <div style="padding: 5px 10px;">
                    <li class="nav-list">
                        <div class="easyui-linkbutton" data-options="iconCls:'icon-reload'" style="border: 0;"
                             href="/druid/index.html">数据库监控
                        </div>
                    </li>
                </div>
            </ul>
        </div>
    </div>
</div>
<div data-options="region:'south',boder:true" style="height:25px;">
    <div style="text-align: center;line-height: 25px;font-size: medium">
        作者:ananan&nbsp;QQ群:981017952
    </div>

</div>
<div data-options="region:'center',border:false">
    <div id="tab" class="easyui-tabs">
        <div title="首页">
            欢迎来到后台管理系统
        </div>
    </div>
</div>
</body>
</html>
