<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>hun-admin</title>
    <link rel="stylesheet" type="text/css" href="static/css/easyui.css"/>
    <link rel="stylesheet" type="text/css" href="static/css/icon.css"/>
    <script type="text/javascript" src="static/js/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="static/js/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="static/js/easyui/easyui-lang-zh_CN.js"></script>
    <%--<link rel="stylesheet" type="text/css" href="static/css/system/login.css"/>--%>
    <script type="text/javascript" src="static/js/system/login.js"></script>
    <script type="text/javascript" src="static/js/system/common.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
<div id="login">
    <div style="padding: 15px 0 0 60px;">
        <p>账号:<input name="username" id="username" style="width: 300px;height: 35px" type="text" class="textbox"></p>
        <p style="padding-top: 20px">密码:<input name="username" id="password" style="width: 300px;height: 35px" type="password" class="textbox"></p>
    </div>
</div>

</body>
</html>
