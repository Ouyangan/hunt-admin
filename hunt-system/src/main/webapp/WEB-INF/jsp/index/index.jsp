<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>hun-admin</title>
    <link rel="stylesheet" type="text/css" href="/static/css/easyui.css"/>
    <link rel="stylesheet" type="text/css" href="/static/css/icon.css"/>
    <script type="text/javascript" src="/static/js/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="/static/js/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="/static/js/easyui/easyui-lang-zh_CN.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body class="easyui-layout">
<div data-options="region:'north',border:false" style="height:45px;"></div>
<div data-options="region:'west',split:true,title:'系统导航'" style="text-align: center;width:200px;">
    <div class="easyui-accordion">
        <div title="系统设置" data-options="selected:true,collapsed:true,collapsible:true">
            <div>
                <ul style="list-style: none;padding:0 0 0 20px">
                    <li class="tab-btn" style="padding: 5px;"><a style=" text-decoration: none;" href="#">用户管理</a></li>
                    <li class="tab-btn" style="padding: 5px;"><a style=" text-decoration: none;" href="#">组织管理</a></li>
                    <li class="tab-btn" style="padding: 5px;"><a style=" text-decoration: none;" href="#">角色管理</a></li>
                    <li class="tab-btn" style="padding: 5px;"><a style=" text-decoration: none;" href="#">权限管理</a></li>
                    <li class="tab-btn" style="padding: 5px;"><a style=" text-decoration: none;" href="#">在线状态</a></li>
                    <li class="tab-btn" style="padding: 5px;"><a style=" text-decoration: none;" href="#">字典管理</a></li>
                </ul>
            </div>
        </div>
    </div>
</div>
<div data-options="region:'south',border:false" style="height:25px"></div>
<div data-options="region:'center',split:true,border:false">
    <div id="tt" class="easyui-tabs" data-options="tabWidth:112">

    </div>
</div>
</body>
</body>
<script type="text/javascript">
    $(function () {
        $(".tab-btn").click(function () {
            var title = $(this).find('a:first').text();
            $('#tt').tabs('add',{
                fit:true,
                title:title,
                closable:true
            });
        })
    });
</script>
</html>
