ip_tool = {
    init_main_view: function () {
        $.ajax({
            data: {},
            method: 'get',
            url: getRootPath() + '/system/ip/intercept/status',
            async: false,
            dataType: 'json',
            success: function (result) {

                if (result.code == 10000) {
                    $('#ip-switchButton-btn').switchbutton({
                        checked: result.data,
                    })
                    return false;
                }
                else {
                    common_tool.messager_show(result.msg);
                }
            },
        });
        $("#ip_grid").datagrid({
            url: getRootPath() + "/system/ip/list",
            method: 'get',
            idField: "id",
            fitColumns: true,
            toolbar: '#ip-tool-bar',
            rownumbers: true,
            singleSelect: true,
            fit: true,
            border: false,
            pagination: true,
            striped: true,
            pagePosition: "bottom",
            pageNumber: 1,
            pageSize: 30,
            pageList: [30, 60, 90, 120],
            columns: [[
                {title: "选择", field: "ck", checkbox: true},
                {title: "IP", field: "ip", width: 300},
                {
                    title: "到期时间", field: "expireTime", formatter: function (value, row, index) {
                    return common_tool.timestampToDateTime(value);
                }, width: 100
                },
                {title: "说明", field: "description", width: 400},
                {
                    title: "创建时间", field: "createTime", formatter: function (value, row, index) {
                    return common_tool.timestampToDateTime(value);
                }, width: 100
                },
                {
                    title: "更新时间", field: "updateTime", formatter: function (value, row, index) {
                    return common_tool.timestampToDateTime(value);
                }, width: 100
                },
            ]],
        });
    },
    init_edit_view: function (type) {
        $("#ip_dialog").dialog({
            title: '新增限制名单',
            iconCls: 'icon-save',
            closable: true,
            width: 430,
            height: 400,
            cache: false,
            modal: true,
            resizable: false,
            'onClose': function () {
                ip_tool.form_clear();
            },
            buttons: [
                {
                    text: '保存',
                    width: 100,
                    iconCls: 'icon-save',
                    handler: function () {
                        if (type == 1) {
                            ip_tool.save();
                        }
                        if (type == 2) {
                            ip_tool.update();
                        }
                    }
                },
                {
                    text: '清除',
                    width: 100,
                    iconCls: 'icon-reload',
                    handler: function () {
                        ip_tool.form_clear();
                    }
                },
                {
                    text: '取消',
                    width: 100,
                    iconCls: 'icon-add',
                    handler: function () {
                        $("#ip_dialog").dialog('close');
                        ip_tool.form_clear();
                    }
                }
            ],
        })
    },
    save: function () {
        if (!$("#ip-name").validatebox('isValid')) {
            common_tool.messager_show("请输入IP地址");
        } else if (!$("#ip-expireTime").datetimebox('isValid')) {
            common_tool.messager_show("请选择截止日期");
        } else if (!$("#ip-description").validatebox('isValid')) {
            common_tool.messager_show("请输入描述");
        } else {
            var ip = $("#ip-name").val();
            var expireTime = $('#ip-expireTime').datebox('getValue');
            var description = $("#ip-description").val();
            $.ajax({
                data: {
                    ip: ip,
                    expireTime: expireTime,
                    description: description,
                },
                traditional: true,
                method: 'post',
                url: getRootPath() + '/system/ip/insert',
                async: false,
                dataType: 'json',
                success: function (result) {
                    if (result.code == 10000) {
                        $("#ip_dialog").dialog("close");
                        ip_tool.form_clear();
                        ip_tool.init_main_view();
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
    update: function () {
        if (!$("#ip-name").validatebox('isValid')) {
            common_tool.messager_show("请输入IP地址");
        } else if (!$("#ip-expireTime").datetimebox('isValid')) {
            common_tool.messager_show("请选择截止日期");
        } else if (!$("#ip-description").validatebox('isValid')) {
            common_tool.messager_show("请输入描述2");
        } else {
            var id = $("#ip-id").val();
            var ip = $("#ip-name").val();
            var expireTime = $('#ip-expireTime').datebox('getValue');
            var description = $("#ip-description").val();
            $.ajax({
                data: {
                    id: id,
                    ip: ip,
                    expireTime: expireTime,
                    description: description,
                },
                traditional: true,
                method: 'post',
                url: getRootPath() + '/system/ip/update',
                async: false,
                dataType: 'json',
                success: function (result) {
                    if (result.code == 10000) {
                        $("#ip_dialog").dialog("close");
                        ip_tool.form_clear();
                        ip_tool.init_main_view();
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
            url: getRootPath() + '/system/ip/delete',
            async: false,
            dataType: 'json',
            success: function (result) {
                if (result.code == 10000) {
                    ip_tool.init_main_view();
                    common_tool.messager_show(result.msg);
                    return false;
                }
                else {
                    common_tool.messager_show(result.msg);
                }
            },
        });
    },
    form_clear: function () {
        $("#ip_form").form("clear");
        $("#ip_grid").datagrid("uncheckAll");
    },
};
$(document).ready(function () {
    ip_tool.init_main_view();
    $("#ip-select-btn").click(function () {
        ip_tool.form_clear();
        ip_tool.init_main_view();
    });
    $("#ip-save-btn").click(function () {
        ip_tool.init_edit_view(1)
    });
    $("#ip-update-btn").click(function () {
        if ($("#ip_grid").datagrid("getChecked").length == 0) {
            common_tool.messager_show("请选择一条记录");
            return false;
        }
        var forbidden = $("#ip_grid").datagrid("getChecked")[0];
        $("#ip_form").form('load', {
            id: forbidden.id,
            ip: forbidden.ip,
            expireTime: common_tool.timestampToDateTime(forbidden.expireTime),
            description: forbidden.description,
        });
        ip_tool.init_edit_view(2);
    });
    $("#ip-delete-btn").click(function () {
        if ($("#ip_grid").datagrid("getChecked").length == 0) {
            common_tool.messager_show("请选择一条记录");
            return false;
        }
        var forbidden = $("#ip_grid").datagrid("getChecked")[0];
        $.messager.confirm('确认对话框', "您确认删除该条记录吗?", function (r) {
            if (r) {
                ip_tool.delete(forbidden.id);
            }
        });
    });
    $('#ip-switchButton-btn').switchbutton({
        onText: '已启用',
        offText: '已关闭',
        onChange: function (checked) {

            $.ajax({
                data: {
                    open: checked,
                },
                method: 'get',
                url: getRootPath() + '/system/ip/intercept',
                async: false,
                dataType: 'json',
                success: function (result) {
                    if (result.code == 10000) {
                        ip_tool.init_main_view();
                        common_tool.messager_show(result.msg);
                        return false;
                    }
                    else {
                        common_tool.messager_show(result.msg);
                    }
                },
            });
        }
    })

});