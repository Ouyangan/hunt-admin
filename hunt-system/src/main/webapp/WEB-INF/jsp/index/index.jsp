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
<body>
<body class="easyui-layout">
<div data-options="region:'north',border:false" style="height:45px;"></div>
<div data-options="region:'west',split:true,title:'导航'" style="text-align: center;width:200px;"></div>
<div data-options="region:'south',border:false" style="height:25px"></div>
<div data-options="region:'center',split:true,border:false">
    <div id="tt" class="easyui-tabs" data-options="tabWidth:112">
        <div title="Tab1" style="padding:10px;height: 100%">
        </div>
        <div title="Tab1" style="padding:10px;height: 100%">
        </div>
    </div>
</div>
</body>
</body>
</html>
