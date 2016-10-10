<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <script type="text/javascript" src="/static/js/easyui/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="/static/js/system/index.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body class="easyui-layout">
<div data-options="region:'north',border:false" style="height:45px;"></div>
<div data-options="region:'west',split:true,title:'系统导航'" style="text-align: center;width:200px;">
    <div class="easyui-accordion">
        <div title="系统设置" data-options="selected:true,collapsed:true,collapsible:true">
            <div>
                <ul style="list-style: none;padding:0 0 0 20px">
                    <li class="tab-btn" style="padding: 5px;"><a style=" text-decoration: none;"
                                                                 href="/user/user">用户管理</a></li>
                    <li class="tab-btn" style="padding: 5px;"><a style=" text-decoration: none;"
                                                                 href="/organization/organization">组织管理</a></li>
                    <li class="tab-btn" style="padding: 5px;"><a style=" text-decoration: none;"
                                                                 href="/role/role">角色管理</a></li>
                    <li class="tab-btn" style="padding: 5px;"><a style=" text-decoration: none;"
                                                                 href="/permission/permission">权限管理</a></li>
                    <li class="tab-btn" style="padding: 5px;"><a style=" text-decoration: none;" href="/user/status">在线状态</a>
                    </li>
                    <li class="tab-btn" style="padding: 5px;"><a style=" text-decoration: none;"
                                                                 href="/data/data">字典管理</a></li>
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
