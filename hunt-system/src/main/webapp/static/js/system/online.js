online_tool = {
    form_clear: function () {
        $("#online_grid").datagrid('uncheckAll');
    },
    init_main_view: function () {
        $("#online_grid").datagrid({
            url: getRootPath() + "/system/online/list",
            method: 'get',
            idField: "id",
            fitColumns: true,
            toolbar: '#online-tool-bar',
            rownumbers: true,
            animate: true,
            singleSelect: false,
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
                {title: "用户id", field: "sysUserId", width: 50, sortable: true},
                {title: "登录名", field: "sysUserLoginName", width: 100, sortable: true},
                {title: "中文名", field: "sysUserZhName", width: 100, sortable: true},
                {
                    title: "平台", field: "platform", sortable: true, formatter: function (value, row, index) {
                    if (value == 1) {
                        return "Web";
                    }
                    if (value == 2) {
                        return "Android";
                    }
                    if (value == 3) {
                        return "Ios";
                    }
                }, width: 60
                },
                {title: "sessionId", field: "sessionId", width: 250},
                {
                    title: "登录时间", field: "createTime", formatter: function (value, row, index) {
                    return common_tool.timestampToDateTime(value);
                }, width: 200
                },

                {
                    title: "上次登陆时间", field: "lastLoginTime", formatter: function (value, row, index) {
                    return common_tool.timestampToDateTime(value);
                }, width: 200
                },
                {
                    title: "过期时间", field: "sessionExpires", formatter: function (value, row, index) {
                    return common_tool.timestampToDateTime(value);
                }, width: 200
                },
            ]],
        });
    },
    force_logout: function (userIds) {
        $.ajax({
            data: {
                userIds: userIds.toString(),
            },
            traditional: true,
            method: 'get',
            url: getRootPath() + '/system/forceLogout',
            async: false,
            dataType: 'json',
            success: function (result) {
                if (result.code == 10000) {
                    online_tool.form_clear();
                    online_tool.init_main_view();
                    common_tool.messager_show(result.msg);
                    return false;
                }
                else {
                    common_tool.messager_show(result.msg);
                }
            },
        });
    }
};
$(document).ready(function () {
    online_tool.init_main_view();
    $("#online-logout-btn").click(function () {
        var users = $("#online_grid").datagrid('getChecked');
        if (users.length == 0) {
            common_tool.messager_show("请至少选择一条记录");
            return false;
        }
        $.messager.confirm('确认对话框', "您确认删除该条记录吗?", function (r) {
            if (r) {
                var userIds = new Array();
                for (var i = 0; i < users.length; i++) {
                    userIds[i] = users[i].sysUserId;
                }
                online_tool.force_logout(userIds)
            }
        });
    });
    $("#online-flash-btn").click(function () {
        online_tool.form_clear();
        online_tool.init_main_view();
    });
    $("#online-flash-btn").click(function () {
        online_tool.form_clear();
        online_tool.init_main_view();
    });
});