<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>hun-admin</title>
    <link type="image/x-icon" rel="shortcut icon" href="${pageContext.request.contextPath}/static/image/favicon.ico">
    <link type="image/x-icon" rel="bookmark" href="${pageContext.request.contextPath}/static/image/favicon.ico">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/easyui.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/icon.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/system/index.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/easyui/jquery.min.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/static/js/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/static/js/easyui/datagrid-groupview.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/static/js/easyui/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/system/common.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/system/index.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body class="easyui-layout">
<div data-options="region:'north',border:false" style="height:40px; background:#198ec2;padding: 0;">
    <div style="height: 40px; float: left; line-height: 40px">
        <span style="font-weight:bolder; font-size: large;padding-left: 10px;color: #ffffff">Hunt-Admin 快速开发平台</span>
    </div>
    <div style="float:right;height: 40px;padding: 0;">

    </div>
    <div style="float:right;height: 40px;padding-top: 0;">
        <span style="color: #ffffff ;font-weight: bolder;">欢迎您:${sessionScope.get("loginInfo").loginName}</span> &nbsp;&nbsp;<input
            id="logout-btn" class="easyui-menubutton logout" value="安全退出">
    </div>
</div>
<div data-options="region:'west',border:true,split:true" style="text-align: center;width:160px;">
    <div class="easyui-accordion" data-options="border:false,fit:true,">
        <div title="系统管理" style="padding: 0 0 0 15px;">
            <ul style="list-style: none;padding: 0 0 0 0 ;">
                <shiro:hasPermission name="user:list">
                    <div style="padding: 5px 10px;">
                        <li class="nav-list">
                            <div class="easyui-linkbutton" data-options="iconCls:'icon-reload'" style="border: 0;"
                                 href="${pageContext.request.contextPath}/user/user">用户管理
                            </div>
                        </li>
                    </div>
                </shiro:hasPermission>
                <shiro:hasPermission name="job:list">
                    <div style="padding: 5px 10px;">
                        <li class="nav-list">
                            <div class="easyui-linkbutton" data-options="iconCls:'icon-reload'" style="border: 0; "
                                 href="${pageContext.request.contextPath}/job/job">职位管理
                            </div>
                        </li>
                    </div>
                </shiro:hasPermission>
                <shiro:hasPermission name="organization:list">
                    <div style="padding: 5px 10px;">
                        <li class="nav-list">
                            <div class="easyui-linkbutton" data-options="iconCls:'icon-reload'" style="border: 0;"
                                 href="${pageContext.request.contextPath}/organization/organization">机构管理
                            </div>
                        </li>
                    </div>
                </shiro:hasPermission>
                <shiro:hasPermission name="role:list">
                    <div style="padding: 5px 10px;">
                        <li class="nav-list">
                            <div class="easyui-linkbutton" data-options="iconCls:'icon-reload'"
                                 style="border: 0;"
                                 href="${pageContext.request.contextPath}/role/role">角色管理
                            </div>
                        </li>
                    </div>
                </shiro:hasPermission>
                <shiro:hasPermission name="permission:list">
                    <div style="padding: 5px 10px;">
                        <li class="nav-list">
                            <div class="easyui-linkbutton" data-options="iconCls:'icon-reload'" style="border: 0;"
                                 href="${pageContext.request.contextPath}/permission/permission">权限管理
                            </div>
                        </li>
                    </div>
                </shiro:hasPermission>
                <shiro:hasPermission name="data:list">
                    <div style="padding: 5px 10px;">
                        <li class="nav-list">
                            <div class="easyui-linkbutton" data-options="iconCls:'icon-reload'" style="border: 0;"
                                 href="${pageContext.request.contextPath}/system/data">数据字典
                            </div>
                        </li>
                    </div>
                </shiro:hasPermission>
                <shiro:hasPermission name="user:loginStatu:list">
                    <div style="padding: 5px 10px;">
                        <li class="nav-list">
                            <div class="easyui-linkbutton" data-options="iconCls:'icon-reload'" style="border: 0;"
                                 href="${pageContext.request.contextPath}/system/online">在线状态
                            </div>
                        </li>
                    </div>
                </shiro:hasPermission>
                <shiro:hasPermission name="log:list">
                    <div style="padding: 5px 10px;">
                        <li class="nav-list">
                            <div class="easyui-linkbutton" data-options="iconCls:'icon-reload'" style="border: 0;"
                                 href="${pageContext.request.contextPath}/system/log">系统日志
                            </div>
                        </li>
                    </div>
                </shiro:hasPermission>
                <shiro:hasPermission name="ip:list">
                    <div style="padding: 5px 10px;">
                        <li class="nav-list">
                            <div class="easyui-linkbutton" data-options="iconCls:'icon-reload'" style="border: 0;"
                                 href="${pageContext.request.contextPath}/system/ip">IP访问限制
                            </div>
                        </li>
                    </div>
                </shiro:hasPermission>
                <shiro:hasPermission name="db:select">
                    <div style="padding: 5px 10px;">
                        <li class="nav-list">
                            <div class="easyui-linkbutton" data-options="iconCls:'icon-reload'" style="border: 0;"
                                 href="${pageContext.request.contextPath}/druid/index.html">数据库监控
                            </div>
                        </li>
                    </div>
                </shiro:hasPermission>
                <div style="padding: 5px 10px;">
                    <li class="nav-list">
                        <div class="easyui-linkbutton" data-options="iconCls:'icon-reload'" style="border: 0;"
                             href="${pageContext.request.contextPath}/swagger-ui.html">接口文档
                        </div>
                    </li>
                </div>
            </ul>
        </div>
    </div>
</div>
<div data-options="region:'south',boder:true" style="height:26px;">
    <div style="text-align: center;line-height: 24px;font-size: inherit">
        作者:ananan&nbsp;QQ群:234700542
    </div>

</div>
<div data-options="region:'center',border:false">
    <div id="tab" class="easyui-tabs" data-options="fit:true">
        <div title="首页">
            欢迎来到后台管理系统
        </div>
    </div>
</div>
</body>
</html>
