$(function () {
    $("#login").dialog({
        title: '系统登录',
        closable: false,
        width: 400,
        height: 200,
        cache: false,
        modal: true,
        resizable: false,
        draggable: false,
        buttons: '#login-btn',
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

    $("#login-btn a").click(function () {
        if (!$("#username").validatebox("isValid")) {
            $("#username").focus();
        } else if (!$("#password").validatebox("isValid")) {
            $("#password").focus();
        } else {
            $.ajax({
                url: "/user/login",
                type: "post",
                dataType: "json",
                data: {
                    username: $("#username").val(),
                    password: $("#password").val(),
                    platform: 1,
                },
                success: function (data) {
                    if (data.code == 10000) {
                        alert("loading")
                    } else {
                        $.messager.show({
                            title: '系统提示',
                            msg: data.msg,
                            timeout: 2000,
                            showType: 'slide'
                        });

                    }
                }
            })
        }
    })
});