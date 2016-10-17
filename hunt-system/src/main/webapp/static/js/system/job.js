job_tool = {
    form_clear: function () {
        $("#job_form").form('clear');
    },
    save: function () {

    },
    update: function () {

    },
    delete: function () {

    },

    init_main_view: function () {
        $("#job_grid").treegrid({
            url: '/job/select',
            method: 'get',
            idField: "id",
            nodeId: 'id',
            treeField: 'name',
            fitColumns: true,
            toolbar: '#job-tool-bar',
            rownumbers: true,
            animate: true,
            fit: true,
            border: false,
            pagePosition: "bottom",
            pageNumber: 1,
            pageSize: 15,
            pageList: [15, 30, 45, 60],
            pagination: false,
            striped: true,
            columns: [[
                {title: "选择", field: "ck", checkbox: true},
                {title: "简称", field: "name", width: 300},
                {title: "全称", field: "fullName", width: 300},
                {title: "组织名称", field: "organizationName", width: 400},
                {title: "角色名称", field: "roleName", width: 400},
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
    init_edit_view: function (type) {
        $("#job_dialog").dialog({
            title: '新增组织机构',
            iconCls: 'icon-save',
            closable: true,
            width: 900,
            height: 400,
            cache: false,
            modal: true,
            resizable: false,
            'onOpen': function () {

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
                        if (data == 1) {
                            job_tool.save();
                        }
                        if (data == 2) {
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
$(document).ready(function () {
    job_tool.init_main_view();
    $("#job-save-btn").click(function () {
        job_tool.init_edit_view(1);
    });
    $("#job-update-btn").click(function () {
        var jobArray = $("#job_grid").treegrid('getChecked');
        if (jobArray.length == 0) {
            common_tool.messager_show("请选择一条记录");
            return false;
        }
        $("#organization_form").form('load', {
            "id": jobArray[0].id,
            "name": jobArray[0].name,
            "fullName": jobArray[0].fullName,
            "description": jobArray[0].description,
        });
        job_tool.init_edit_view(2);
    });
    $("#job-delete-btn").click(function () {
        var jobArray = $("#job_grid").treegrid('getChecked');
        if (jobArray.length == 0) {
            common_tool.messager_show("请选择一条记录");
            return false;
        }
        job_tool.delete();
    });
    $("#job-select-btn").click(function () {
        job_tool.init_main_view();
    });

});