permission_tool = {
    init_data: function () {
        var data_json = '';
        $.ajax({
            method: 'get',
            url: '/permission/permission',
            async: false,
            dataType: 'json',
            success: function (result) {
                if (result.code == 10000) {
                    data_json = result.data;
                    console.log(data_json);
                }
                else {
                    common_tool.messager_show(result.msg);
                }
            },
        });
        return data_json;
    },
    delte_permission: function () {
        if ($("#permission_grid").treegrid("getChecked").length == 0) {
            common_tool.messager_show("请选择一条记录");
        } else {
            var id = $("#permission_grid").treegrid("getChecked")[0].id;
            $.ajax({
                data: {
                    id: id,
                },
                method: 'get',
                url: '/permission/delete',
                async: false,
                dataType: 'json',
                success: function (result) {
                    if (result.code == 10000) {
                        permission_tool.init_main_view();
                        return false;
                    }
                    else {
                        common_tool.messager_show(result.msg);
                    }
                },
            });
        }
    },
    save_permission: function () {
        if (!$("#name").validatebox('isValid')) {
            common_tool.messager_show("请输入权限名称");
        } else if (!$("#code").validatebox('isValid')) {
            common_tool.messager_show("请输入权限编码");
        }
        else if (!$("#name").validatebox('isValid')) {
            common_tool.messager_show("请输入权限描述");
        }
        else if ($("#permission-group").treegrid("getChecked").length == 0) {
            common_tool.messager_show("请选择权限组");
        } else {
            var name = $("#name").val();
            var code = $("#code").val();
            var description = $("#description").val();
            var groupId = $("#permission-group").treegrid("getChecked")[0].id;
            $.ajax({
                data: {
                    name: name,
                    code: code,
                    description: description,
                    groupId: groupId,
                },
                method: 'post',
                url: '/permission/insert',
                async: false,
                dataType: 'json',
                success: function (result) {
                    if (result.code == 10000) {
                        $("#save-permission-dialog").dialog("close");
                        $("#save-permission-form").form('clear');
                        permission_tool.init_main_view();
                        return false;
                    }
                    else {
                        common_tool.messager_show(result.msg);
                    }
                },
            });
        }
    },
    update_permission: function () {
        if (!$("#name").validatebox('isValid')) {
            common_tool.messager_show("请输入权限名称1");
        } else if (!$("#code").validatebox('isValid')) {
            common_tool.messager_show("请输入权限编码");
        }
        else if (!$("#name").validatebox('isValid')) {
            common_tool.messager_show("请输入权限描述");
        }
        else if ($("#permission-group").treegrid("getChecked").length == 0) {
            common_tool.messager_show("请选择权限组");
        } else {
            var id = $("#id").val();
            var name = $("#name").val();
            var code = $("#code").val();
            var description = $("#description").val();
            var groupId = $("#permission-group").treegrid("getChecked")[0].id;
            $.ajax({
                data: {
                    id: id,
                    name: name,
                    code: code,
                    description: description,
                    groupId: groupId,
                },
                method: 'post',
                url: '/permission/update',
                async: false,
                dataType: 'json',
                success: function (result) {
                    if (result.code == 10000) {
                        $("#save-permission-dialog").dialog("close");
                        $("#save-permission-form").form('clear');
                        permission_tool.init_main_view();
                        return false;
                    }
                    else {
                        common_tool.messager_show(result.msg);
                    }
                },
            });
        }
    },
    insert_permission_group: function () {
        if (!$("#group_name").validatebox('isValid')) {
            common_tool.messager_show("请输入权限名称");
        } else if (!$("#group_description").validatebox('isValid')) {
            common_tool.messager_show("请输入权限编码");
        } else {
            var group_name = $("#group_name").val();
            var group_description = $("#group_description").val();
            $.ajax({
                data: {
                    name: group_name,
                    description: group_description,
                },
                method: 'post',
                url: '/permission/insertGroup',
                async: false,
                dataType: 'json',
                success: function (result) {
                    if (result.code == 10000) {
                        $("#save-permission-group-dialog").dialog("close");
                        $("#save-permission-group-form").form('clear');
                        permission_tool.init_main_view();
                        return false;
                    }
                    else {
                        common_tool.messager_show(result.msg);
                    }
                },
            });
        }
    },
    init_edit_group_view: function () {
        $("#save-permission-group-dialog").dialog({
            title: '新增权限组',
            iconCls: 'icon-save',
            closable: true,
            width: 450,
            height: 350,
            cache: false,
            modal: true,
            resizable: false,
            buttons: [
                {
                    text: '保存',
                    width: 100,
                    iconCls: 'icon-save',
                    handler: function () {
                        permission_tool.insert_permission_group();
                    }
                },
                {
                    text: '清除',
                    width: 100,
                    iconCls: 'icon-reload',
                    handler: function () {
                        $("#save-permission-group-form").form('clear');
                    }
                },
                {
                    text: '取消',
                    width: 100,
                    iconCls: 'icon-add',
                    handler: function () {
                        $("#save-permission-group-dialog").dialog('close');
                        $("#save-permission-group-form").form('clear');
                    }
                }
            ],
        });
    },
    init_edit_view: function (type, groupId) {
        $("#save-permission-dialog").dialog({
            title: '新增权限',
            iconCls: 'icon-save',
            closable: true,
            width: 700,
            height: 400,
            cache: false,
            modal: true,
            resizable: false,
            'onOpen': function () {
                if (groupId != null) {
                    console.log(groupId);
                    $("#permission-group").datagrid('selectRecord', groupId);
                }
            },
            buttons: [
                {
                    text: '保存',
                    width: 100,
                    iconCls: 'icon-save',
                    handler: function () {
                        if (type == 1) {
                            permission_tool.save_permission();
                        }
                        if (type == 2) {
                            permission_tool.update_permission();
                        }
                    }
                },
                {
                    text: '清除',
                    width: 100,
                    iconCls: 'icon-reload',
                    handler: function () {
                        $("#save-permission-form").form('clear');
                    }
                },
                {
                    text: '取消',
                    width: 100,
                    iconCls: 'icon-add',
                    handler: function () {
                        $("#save-permission-dialog").dialog('close');
                        $("#save-permission-form").form('clear');
                    }
                }
            ],
        });
    },
    init_main_view: function () {
        $("#permission_grid").datagrid({
            url: "/permission/select",
            method: 'get',
            view: groupview,
            groupField: 'sysPermissionGroupId',
            groupFormatter: function (value, rows) {
                return rows[0].sysPermissionGroupName;
            },
            fitColumns: true,
            toolbar: '#permission-tool-bar',
            rownumbers: true,
            singleSelect: true,
            animate: true,
            fit: true,
            border: false,
            pagePosition: "bottom",
            pageNumber: 1,
            pageSize: 25,
            pageList: [25, 50, 75, 100],
            pagination: true,
            striped: true,
            columns: [[
                {title: "选择", field: "ck", checkbox: true},
                {title: "名称", field: "name", width: 300},
                {title: "code", field: "code", width: 300},
                {title: "说明", field: "description", width: 400},
                {
                    title: "是否可修改", field: "isFinal", formatter: function (value, row, index) {
                    if (value == 1) {
                        return "是";
                    }
                    if (value == 2) {
                        return "否";
                    }
                }, width: 60
                },
                {
                    title: "创建时间", field: "createTime", formatter: function (value, row, index) {
                    date = new Date(value);
                    timeStr = date.getFullYear() + "-" + date.getMonth() + "-" + date.getDay() + " " + date.getHours() + ":" + date.getMinutes();
                    return timeStr;
                }, width: 100
                },
                {
                    title: "更新时间", field: "updateTime", formatter: function (value, row, index) {
                    date = new Date(value);
                    timeStr = date.getFullYear() + "-" + date.getMonth() + "-" + date.getDay() + " " + date.getHours() + ":" + date.getMinutes();
                    return timeStr;
                }, width: 100
                },
            ]],
        });
    },
}
$(document).ready(function () {
    permission_tool.init_main_view();
    $("#flash-permission").click(function () {
        console.log("刷新")
        permission_tool.init_main_view();
        return false;
    });
    $("#save-permission").click(function () {
        permission_tool.init_edit_view(1);
    });
    $("#save-permissionGroup").click(function () {
        permission_tool.init_edit_group_view()
    });
    $("#delete-permission").click(function () {
        permission_tool.delte_permission();
    });
    $("#update-permission").click(function () {
        if ($("#permission_grid").treegrid("getChecked").length == 0) {
            common_tool.messager_show("请选择一条记录");
            return false;
        }
        var permission = $("#permission_grid").datagrid('getChecked')[0];
        $("#save-permission-form").form('load', {
            'id': permission.id,
            'name': permission.name,
            'code': permission.code,
            'description': permission.description,
        });
        permission_tool.init_edit_view(2, permission.sysPermissionGroupId);
    });

});