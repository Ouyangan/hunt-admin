$(function () {
    $("#login").dialog({
        title: '系统登录',
        closable: false,
        width: 500,
        height: 300,
        cache: false,
        modal: true,
        resizable: false,
        draggable: false,
        buttons: [
            {
            text: '登录',
            width: 100,
            handler: function () {
                if (!$("#username").validatebox("isValid")) {
                    $("#username").focus();
                } else if (!$("#password").validatebox("isValid")) {
                    $("#password").focus();
                } else {
                    $.ajax({
                        url: "/system/login",
                        type: "post",
                        dataType: "json",
                        data: {
                            loginName: $("#username").val(),
                            password: $("#password").val(),
                            platform: 1,
                        },
                        success: function (data) {
                            if (data.code == 10000) {
                                location.href = "/system/index";
                            } else {
                                common_tool.messager_show(data.msg)
                            }
                        }
                    })
                }
            }
        },
        ],
    });

    $('#username').validatebox({
        required: true,
        missingMessage: '请输入账号',
    });
    $('#password').validatebox({
        required: true,
        validType: 'length[6, 30]',
        missingMessage: '请输入密码',
        invalidMessage: '请输入6-30位密码',
    });
    if (!$("#username").validatebox("isValid")) {
        $("#username").focus();
    } else if (!$("#password").validatebox("isValid")) {
        $("#password").focus();
    }

});