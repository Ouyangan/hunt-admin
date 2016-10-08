<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
    <title>hun-admin</title>
    <link rel="stylesheet" type="text/css" href="${ctx}/static/css/easyui.css"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/static/css/icon.css"/>
    <script type="text/javascript" src="${ctx}/static/js/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="${ctx}/static/js/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${ctx}/static/js/easyui/easyui-lang-zh_CN.js"></script>
</head>
<body>
<div id="p" class="easyui-panel" title="Basic Panel" style="width:500px;height:200px;padding:10px;">
    第一个easyui-panel
</div>
</body>
</html>
