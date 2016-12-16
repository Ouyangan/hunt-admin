job_tool = {
    form_clear: function () {
        $("#job_form").form('reset');
        $("#job_form").form('clear');
        $("#job_dialog_parent_tree").treegrid("uncheckAll");
        $("#job_dialog_organization").treegrid("uncheckAll");
        $("#job_dialog_role").datagrid("uncheckAll");
        $("#job_grid").treegrid("uncheckAll");
    },
    checkValidatebox: function () {
        if (!$('#job_dialog input[id="name"]').validatebox('isValid')) {
            common_tool.messager_show('请输入名称');
            return false;
        } else if (!$('#job_dialog input[id="fullName"]').validatebox('isValid')) {
            common_tool.messager_show('请输入全称');
            return false;
        } else if (!$('#job_dialog input[id="description"]').validatebox('isValid')) {
            common_tool.messager_show('请输入描述');
            return false;
        } else if ($('#job_dialog table[id="job_dialog_parent_tree"]').treegrid("getChecked").length == 0) {
            common_tool.messager_show('请选择上级职位');
            return false;
        } else if ($('#job_dialog table[id="job_dialog_role"]').datagrid("getChecked").length == 0) {
            common_tool.messager_show('请选择系统角色');
            return false;
        } else if ($('#job_dialog table[id="job_dialog_organization"]').treegrid("getChecked").length == 0) {
            common_tool.messager_show('请选择组织机构');
            return false;
        }
        return true;
    },
    save: function () {
        if (!job_tool.checkValidatebox()) {
            return false;
        }
        var name = $('#job_dialog input[id="name"]').val();
        var fullName = $('#job_dialog input[id="fullName"]').val();
        var description = $('#job_dialog input[id="description"]').val();
        var parent_job = $('#job_dialog table[id="job_dialog_parent_tree"]').treegrid("getChecked")[0];
        var role = $('#job_dialog table[id="job_dialog_role"]').datagrid("getChecked")[0];
        var organization = $('#job_dialog table[id="job_dialog_organization"]').treegrid("getChecked")[0];
        $.ajax({
            data: {
                name: name,
                fullName: fullName,
                description: description,
                parentId: parent_job.id,
                roleId: role.id,
                organizationId: organization.id,
            },
            method: 'post',
            url: getRootPath() + '/job/insert',
            async: false,
            dataType: 'json',
            success: function (result) {
                if (result.code == 10000) {
                    $("#job_dialog").dialog('close');
                    job_tool.form_clear();
                    job_tool.init_main_view();
                }
                else {
                    common_tool.messager_show(result.msg);
                }
            },
        });

    }
    ,
    update: function () {
        if (!job_tool.checkValidatebox()) {
            return false;
        }
        var id = $('#job_dialog input[id="id"]').val();
        var name = $('#job_dialog input[id="name"]').val();
        var fullName = $('#job_dialog input[id="fullName"]').val();
        var description = $('#job_dialog input[id="description"]').val();
        var parent_job = $('#job_dialog table[id="job_dialog_parent_tree"]').treegrid("getChecked")[0];
        var role = $('#job_dialog table[id="job_dialog_role"]').datagrid("getChecked")[0];
        var organization = $('#job_dialog table[id="job_dialog_organization"]').treegrid("getChecked")[0];
        $.ajax({
            data: {
                id: id,
                name: name,
                fullName: fullName,
                description: description,
                parentId: parent_job.id,
                roleId: role.id,
                organizationId: organization.id,
            },
            method: 'post',
            url: getRootPath() + '/job/update',
            async: false,
            dataType: 'json',
            success: function (result) {
                if (result.code == 10000) {
                    $("#job_dialog").dialog('close');
                    job_tool.form_clear();
                    job_tool.init_main_view();
                }
                else {
                    common_tool.messager_show(result.msg);
                }
            },
        });
    },
    delete: function (id) {
        $.ajax({
            data: {
                id: id,
            },
            method: 'get',
            url: getRootPath() + '/job/delete',
            async: false,
            dataType: 'json',
            success: function (result) {
                if (result.code == 10000) {
                    job_tool.form_clear();
                    job_tool.init_main_view();
                }
                else {
                    common_tool.messager_show(result.msg);
                }
            },
        });
    }
    ,
    init_main_view: function () {
        $("#job_grid").treegrid({
            url: getRootPath() + '/job/list',
            method: 'get',
            idField: "id",
            nodeId: 'id',
            treeField: 'name',
            toolbar: '#job-tool-bar',
            // lines: true,
            rownumbers: true,
            animate: true,
            fit: true,
            fitColumns: true,
            border: false,
            pagePosition: "bottom",
            pageNumber: 1,
            pageSize: 15,
            pageList: [15, 30, 45, 60],
            pagination: false,
            striped: true,
            columns: [[
                {title: "选择", field: "ck", checkbox: true},
                {title: "简称", field: "name", width: 250},
                {title: "全称", field: "fullName", width: 300},
                {title: "组织名称", field: "sysOrganizationName", width: 300},
                {title: "角色名称", field: "sysRoleName", width: 300},
                {title: "说明", field: "description", width: 300},
                {
                    title: "是否可修改", field: "isFinal", formatter: function (value, row, index) {
                    if (value == 1) {
                        return "是";
                    }
                    if (value == 2) {
                        return "否";
                    }
                }, width: 100
                },
                {
                    title: "创建时间", field: "createTime", formatter: function (value, row, index) {
                    return common_tool.timestampToDateTime(value);
                }, width: 160
                },
                {
                    title: "更新时间", field: "updateTime", formatter: function (value, row, index) {
                    return common_tool.timestampToDateTime(value);
                }, width: 160
                },
            ]],
            onDblClickRow: function (index, row) {
                var job = $("#job_grid").treegrid('getChecked')[0];
                if (job == null) {
                    common_tool.messager_show("请选择一条记录");
                    return false;
                }
                $("#job_form").form('load', {
                    "id": job.id,
                    "name": job.name,
                    "fullName": job.fullName,
                    "description": job.description,
                });
                $("#job_dialog").dialog({
                    title: '新增职位',
                    iconCls: 'icon-save',
                    closable: true,
                    width: 1200,
                    height: 400,
                    cache: false,
                    modal: true,
                    resizable: false,
                    'onOpen': function () {
                        var job = $("#job_grid").treegrid('getChecked')[0];
                        $("#job_dialog_parent_tree").treegrid('select', job.parentId);
                        $("#job_dialog_role").datagrid('selectRecord', job.sysRoleId);
                        $("#job_dialog_organization").treegrid('select', job.sysOrganizationId);
                    },
                    'onClose': function () {
                        job_tool.form_clear();
                    },
                })
            },
        });
    }
    ,
    init_edit_view: function (type) {
        $("#job_dialog").dialog({
            title: '新增职位',
            iconCls: 'icon-save',
            closable: true,
            width: 1200,
            height: 400,
            cache: false,
            modal: true,
            resizable: false,
            'onOpen': function () {
                if (type == 2) {
                    var job = $("#job_grid").treegrid('getChecked')[0];
                    $("#job_dialog_parent_tree").treegrid('select', job.parentId);
                    $("#job_dialog_role").datagrid('selectRecord', job.sysRoleId);
                    $("#job_dialog_organization").treegrid('select', job.sysOrganizationId);
                }
            },
            'onClose': function () {
                job_tool.form_clear();
            },
            buttons: [
                {
                    text: '保存',
                    width: 100,
                    iconCls: 'icon-save',
                    handler: function () {
                        if (type == 1) {
                            job_tool.save();
                        }
                        if (type == 2) {
                            job_tool.update();
                        }
                    }
                },
                {
                    text: '清除',
                    width: 100,
                    iconCls: 'icon-reload',
                    handler: function () {
                        job_tool.form_clear();
                    }
                },
                {
                    text: '取消',
                    width: 100,
                    iconCls: 'icon-add',
                    handler: function () {
                        $("#job_dialog").dialog('close');
                        job_tool.form_clear();
                    }
                }
            ],
        })
    }
}
;
$(document).ready(function () {
    job_tool.init_main_view();
    $("#job-save-btn").click(function () {
        job_tool.init_edit_view(1);
    });
    $("#job-update-btn").click(function () {
        var job = $("#job_grid").treegrid('getChecked')[0];
        if (job == null) {
            common_tool.messager_show("请选择一条记录");
            return false;
        }
        $("#job_form").form('load', {
            "id": job.id,
            "name": job.name,
            "fullName": job.fullName,
            "description": job.description,
        });
        job_tool.init_edit_view(2);
    });
    $("#job-delete-btn").click(function () {
        var job = $("#job_grid").treegrid('getChecked');
        if (job.length == 0) {
            common_tool.messager_show("请选择一条记录");
            return false;
        }
        $.messager.confirm('确认对话框', "您确认删除该条记录吗?", function (r) {
            if (r) {
                job_tool.delete(job[0].id);
            }
        });
    });
    $("#job-select-btn").click(function () {
        job_tool.form_clear();
        job_tool.init_main_view();
    });
});