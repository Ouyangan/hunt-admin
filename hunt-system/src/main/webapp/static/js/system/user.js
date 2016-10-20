user_tool = {
    form_clear: function () {
        $("#user_form").form('reset');
        $("#user_form").form('clear');
        $("#permissions").treegrid("uncheckAll");
        $("#jobs").treegrid("uncheckAll");
        $("#user_grid").treegrid("uncheckAll");
    },
    init_main_view: function () {
        $("#user_grid").datagrid({
            url: "/user/select",
            method: 'get',
            idField: "id",
            treeField: 'zhName',
            fitColumns: true,
            toolbar: '#user-tool-bar',
            rownumbers: true,
            animate: true,
            singleSelect: true,
            fit: true,
            border: false,
            pagination: true,
            striped: true,
            pagePosition: "bottom",
            pageNumber: 1,
            pageSize: 15,
            pageList: [15, 30, 45, 60],
            columns: [[
                {title: "选择", field: "ck", checkbox: true},
                {title: "中文名", field: "zhName", width: 200, sortable: true},
                {title: "登录名", field: "loginName", width: 200, sortable: true},
                {title: "英文名", field: "enName", width: 200, sortable: true},
                {
                    title: "性别", width: 200, field: "sex", formatter: function (value, row, index) {
                    if (value == 1) {
                        return "男";
                    }
                    if (value == 2) {
                        return "女";
                    }
                }
                },
                {
                    title: "状态", field: "status", align: 'center', width: 120, formatter: function (value, row, index) {
                    if (value == 1) {
                        return "<div class='easyui-switchbutton status' checked ></div>";
                    }
                    if (value == 3) {
                        return "<div class='easyui-switchbutton status' unchecked ></div>";
                    }

                }
                },
                {title: "生日", field: "birth", width: 200},
                {title: "邮箱", field: "email", width: 200, sortable: true},
                {title: "电话", field: "phone", width: 200, sortable: true},
                {title: "地址", field: "address", width: 200},
                {
                    title: "是否可修改", field: "isFinal", formatter: function (value, row, index) {
                    if (value == 1) {
                        return "是";
                    }
                    if (value == 2) {
                        return "否";
                    }
                }, width: 200
                },
                {
                    title: "创建时间", field: "createTime", formatter: function (value, row, index) {
                    date = new Date(value);
                    timeStr = date.getFullYear() + "-" + date.getMonth() + "-" + date.getDay() + " " + date.getHours() + ":" + date.getMinutes();
                    return timeStr;
                }, width: 200
                },
                {
                    title: "更新时间", field: "updateTime", formatter: function (value, row, index) {
                    date = new Date(value);
                    timeStr = date.getFullYear() + "-" + date.getMonth() + "-" + date.getDay() + " " + date.getHours() + ":" + date.getMinutes();
                    return timeStr;
                }, width: 200
                },
            ]],
            onLoadSuccess: function (data) {
                console.log("onLoadSuccess")
                $(".status").switchbutton({
                    readonly: true,
                    onText: '已启用',
                    offText: '已禁用',
                    width: 80,
                })
            },
            onBeforeLoad: function (data) {
                console.log("onBeforeLoad")
            },
            onLoadError: function () {
                console.log("onLoadError")
            },
            onLoad: function () {
                console.log("onLoad")
            }
        });
    },
    init_edit_view: function (type) {
        $("#user_edit_dialog").dialog({
            title: '新增用户',
            iconCls: 'icon-save',
            closable: true,
            width: 950,
            height: 700,
            cache: false,
            modal: true,
            resizable: false,
            'onBeforeOpen': function () {

            },
            'onOpen': function () {
                if (type == 2) {
                    var users = $("#user_grid").datagrid('getChecked')[0];
                    for (var i = 0; i < users.permissions.length; i++) {
                        $("#permissions").datagrid("selectRecord", users.permissions[i].id);
                    }
                    for (var i = 0; i < users.userRoleOrganizations.length; i++) {
                        $("#jobs").treegrid("select", users.userRoleOrganizations[i].sysRoleOrganizationId);
                    }
                }
            },
            'onClose': function () {
                user_tool.form_clear();
            },
            buttons: [
                {
                    text: '保存',
                    width: 100,
                    iconCls: 'icon-save',
                    handler: function () {
                        if (type == 1) {
                            user_tool.save();
                        }
                        if (type == 2) {
                            user_tool.update();
                        }
                    }
                },
                {
                    text: '清除',
                    width: 100,
                    iconCls: 'icon-reload',
                    handler: function () {
                        user_tool.form_clear();
                    }
                },
                {
                    text: '取消',
                    width: 100,
                    iconCls: 'icon-add',
                    handler: function () {
                        user_tool.form_clear();
                        $("#user_edit_dialog").dialog('close');
                    }
                }
            ],
        })
    },

    save: function () {
        var form_isValid = $("#user_form").form('validate');
        if (!form_isValid) {
            common_tool.messager_show("请输入必填参数")
        } else if ($("#jobs").treegrid("getChecked").length == 0) {
            common_tool.messager_show('请选择职位');
        } else if ($("#permissions").datagrid("getChecked").length == 0) {
            common_tool.messager_show('请选择权限');
        } else {
            var loginName = $('#loginName').val();
            var zhName = $('#zhName').val();
            var enName = $('#enName').val();
            var sex = $('#sex').val();
            var birth = $('#birth').datebox('getValue');
            var email = $('#email').val();
            var phone = $('#phone').val();
            var address = $('#address').val();
            var password = $('#password').val();
            var permissions = $("#permissions").datagrid("getChecked");
            var permissionIds = new Array();
            for (var i = 0; i < permissions.length; i++) {
                permissionIds[i] = permissions[i].id;
            }
            var jobs = $("#jobs").treegrid("getChecked");
            var jobIds = new Array();
            for (var i = 0; i < jobs.length; i++) {
                jobIds[i] = jobs[i].id;
            }
            $.ajax({
                data: {
                    loginName: loginName,
                    zhName: zhName,
                    enName: enName,
                    sex: sex,
                    birth: birth,
                    email: email,
                    phone: phone,
                    address: address,
                    password: password,
                    permissionIds: permissionIds.toString(),
                    jobIds: jobIds.toString(),
                },
                traditional: true,
                method: 'post',
                url: '/user/insert',
                async: false,
                dataType: 'json',
                success: function (result) {
                    if (result.code == 10000) {
                        $("#user_edit_dialog").dialog("close");
                        user_tool.form_clear();
                        user_tool.init_main_view();
                        common_tool.messager_show(result.msg);
                        return false;
                    }
                    else {
                        common_tool.messager_show(result.msg);
                    }
                },
            });

        }

    },
    update: function (data) {
        var form_isValid = $("#user_form").form('validate');
        if (!form_isValid) {
            common_tool.messager_show("请输入必填参数")
        } else if ($("#jobs").treegrid("getChecked").length == 0) {
            common_tool.messager_show('请选择职位');
        } else if ($("#permissions").datagrid("getChecked").length == 0) {
            common_tool.messager_show('请选择权限');
        } else {
            var id = $('#id').val();
            var loginName = $('#loginName').val();
            var zhName = $('#zhName').val();
            var enName = $('#enName').val();
            var sex = $('#sex ').val();
            var birth = $('#birth').datebox('getValue');
            var email = $('#email').val();
            var phone = $('#phone').val();
            var address = $('#address').val();
            var permissions = $("#permissions").datagrid("getChecked");
            var permissionIds = new Array();
            for (var i = 0; i < permissions.length; i++) {
                permissionIds[i] = permissions[i].id;
            }
            var jobs = $("#jobs").treegrid("getChecked");
            var jobIds = new Array();
            for (var i = 0; i < jobs.length; i++) {
                jobIds[i] = jobs[i].id;
            }
            $.ajax({
                data: {
                    id: id,
                    loginName: loginName,
                    zhName: zhName,
                    enName: enName,
                    sex: sex,
                    birth: birth,
                    email: email,
                    phone: phone,
                    address: address,
                    permissionIds: permissionIds.toString(),
                    jobIds: jobIds.toString(),
                },
                traditional: true,
                method: 'post',
                url: '/user/update',
                async: false,
                dataType: 'json',
                success: function (result) {
                    if (result.code == 10000) {
                        $("#user_edit_dialog").dialog("close");
                        user_tool.form_clear();
                        user_tool.init_main_view();
                        common_tool.messager_show(result.msg);
                        return false;
                    }
                    else {
                        common_tool.messager_show(result.msg);
                    }
                },
            });

        }
    },
    delete: function (id) {
        $.ajax({
            data: {
                id: id,
            },
            traditional: true,
            method: 'get',
            url: '/user/delete',
            async: false,
            dataType: 'json',
            success: function (result) {
                if (result.code == 10000) {
                    user_tool.form_clear();
                    user_tool.init_main_view();
                    common_tool.messager_show(result.msg);
                    return false;
                }
                else {
                    common_tool.messager_show(result.msg);
                }
            },
        });
    },
    init_password_view: function () {

    },
    init_password: function (id, oldPassword, newPassword) {

    },
    forbiddenUser: function (id) {
        $.ajax({
            data: {
                id: id,
            },
            traditional: true,
            method: 'get',
            url: '/user/forbiddenUser',
            async: false,
            dataType: 'json',
            success: function (result) {
                if (result.code == 10000) {
                    user_tool.form_clear();
                    user_tool.init_main_view();
                    common_tool.messager_show(result.msg);
                    return false;
                }
                else {
                    common_tool.messager_show(result.msg);
                }
            },
        });
    },
    enableUser: function (id) {
        $.ajax({
            data: {
                id: id,
            },
            traditional: true,
            method: 'get',
            url: '/user/enableUser',
            async: false,
            dataType: 'json',
            success: function (result) {
                if (result.code == 10000) {
                    user_tool.form_clear();
                    user_tool.init_main_view();
                    common_tool.messager_show(result.msg);
                    return false;
                }
                else {
                    common_tool.messager_show(result.msg);
                }
            },
        });
    },

};
$(document).ready(function () {
    user_tool.init_main_view();
    $("#user-save-btn").click(function () {
        user_tool.init_edit_view(1);
    });
    $("#user-update-btn").click(function () {
        var users = $("#user_grid").datagrid('getChecked');
        if (users.length == 0) {
            common_tool.messager_show("请至少选择一条记录");
            return false;
        }
        $("#user_form").form('load', {
            id: users[0].id,
            loginName: users[0].loginName,
            zhName: users[0].zhName,
            enName: users[0].enName,
            sex: users[0].sex,
            birth: users[0].birth,
            email: users[0].email,
            phone: users[0].phone,
            address: users[0].address,
            password: '111111111111',
        });
        user_tool.init_edit_view(2);
    });
    $("#user-delete-btn").click(function () {
        var users = $("#user_grid").datagrid('getChecked');
        if (users.length == 0) {
            common_tool.messager_show("请至少选择一条记录");
            return false;
        }
        $.messager.confirm('确认对话框', "您确认删除该条记录吗?", function (r) {
            if (r) {
                user_tool.delete(users[0].id);
            }
        });
    });
    $("#user-detail-btn").click(function () {

    });
    $("#user-enable-btn").click(function () {
        var users = $("#user_grid").datagrid('getChecked');
        if (users.length == 0) {
            common_tool.messager_show("请至少选择一条记录");
            return false;
        }
        if (users[0].status == 1) {
            console.log('asfasfd')
            common_tool.messager_show("该账号已经处于启用状态");
            return false;
        }
        $.messager.confirm('确认对话框', "您确认启用 " + users[0].zhName + " 账号吗?", function (r) {
            if (r) {
                user_tool.enableUser(users[0].id)
            }
        });
    });
    $("#user-forbidden-btn").click(function () {
        var users = $("#user_grid").datagrid('getChecked');
        if (users.length == 0) {
            common_tool.messager_show("请至少选择一条记录");
            return false;
        }
        if (users[0].status == 3) {
            common_tool.messager_show("该账号已经处于禁用状态");
            return false;
        }
        $.messager.confirm('确认对话框', "您确认禁用 " + users[0].zhName + " 账号吗?", function (r) {
            if (r) {
                user_tool.forbiddenUser(users[0].id)
            }
        });
    });
    $("#user-flash-btn").click(function () {
        user_tool.form_clear();
        user_tool.init_main_view();
    });

});