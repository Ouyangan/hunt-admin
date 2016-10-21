<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>hun-admin</title>
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
<div data-options="region:'north',border:false" style="height:45px;"></div>
<div data-options="region:'west',split:true,title:'系统导航'" style="text-align: center;width:200px;">
    <div class="easyui-accordion">
        <div title="系统管理" class="" data-options="selected:true,collapsed:true,collapsible:true">
            <div>
                <ul style="list-style: none;padding:0 0 0 20px">
                    <li class="tab-btn" style="padding: 5px;">
                        <div style=" text-decoration: none;"
                             href="/user/toUser">用户管理
                        </div>
                    </li>
                    <li class="tab-btn" style="padding: 5px;">
                        <div style=" text-decoration: none;"
                             href="/organization/toOrganization">组织机构管理
                        </div>
                    </li>
                    <li class="tab-btn" style="padding: 5px;">
                        <div style=" text-decoration: none;"
                             href="/role/toRole">角色管理
                        </div>
                    </li>
                    <li class="tab-btn" style="padding: 5px;">
                        <div style=" text-decoration: none;"
                             href="/job/toJob">职位管理
                        </div>
                    </li>
                    <li class="tab-btn" style="padding: 5px;">
                        <div style=" text-decoration: none;"
                             href="/permission/toPermission">权限管理
                        </div>
                    </li>
                    <li class="tab-btn" style="padding: 5px;">
                        <div style=" text-decoration: none;" href="/system/toOnline">在线状态</div>
                    </li>
                    <li class="tab-btn" style="padding: 5px;">
                        <div style=" text-decoration: none;"
                             href="/data/toData">字典管理
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>
<div data-options="region:'south',border:false" style="height:25px"></div>
<div data-options="region:'center',border:false">
    <div id="tab" class="easyui-tabs">
        <div title="首页">
            欢迎来到后台管理系统
        </div>
    </div>
</div>
</body>
</body>
</html>
