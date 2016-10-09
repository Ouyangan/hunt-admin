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
    <link rel="stylesheet" type="text/css" href="static/css/user/login.css"/>
    <script type="text/javascript" src="static/js/user/login.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
<div id="login">
    <p>账号:<input name="username" id="username" type="text" class="textbox"></p>
    <p>密码:<input name="username" id="password" type="password" class="textbox"></p>
</div>
<div id="login-btn">
    <a href="#" class="easyui-linkbutton">登录</a>
</div>
</body>
</html>
