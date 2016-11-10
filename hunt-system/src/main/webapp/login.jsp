<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>hun-admin</title>
    <link type="image/x-icon" rel="shortcut icon" href="${pageContext.request.contextPath}/static/image/favicon.ico">
    <link type="image/x-icon" rel="bookmark" href="${pageContext.request.contextPath}/static/image/favicon.ico">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/easyui.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/icon.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/easyui/jquery.min.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/static/js/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/static/js/easyui/easyui-lang-zh_CN.js"></script>
    <%--<link rel="stylesheet" type="text/css" href=${pageContext.request.contextPath}/static/css/system/login.css"/>--%>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/system/common.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/system/login.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/static/js/system/http_static.geetest.com_static_tools_gt.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
<div id="login">
    <div style="padding: 15px 50px 0 60px;">
        <p>账号:<input name="username" id="username" style="width: 300px;height: 35px" type="text" class="textbox"></p>
        <p style="padding-top: 10px;padding-bottom: 15px">密码:<input name="username" id="password"
                                                                    style="width: 300px;height: 35px"
                                                                    type="password" class="textbox"></p>
        <div id="embed-captcha" style="padding-left:35px;width: 290px ;height: 188px;"></div>


        <br><br>
        <%--<hr>--%>

        <%--<div id="github" class="easyui-linkbutton">使用github登录</div>--%>
    </div>
</div>
</body>
</html>
