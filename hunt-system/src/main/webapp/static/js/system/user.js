user_tool = {
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
                {title: "名称", field: "zhName", width: 300},
                {title: "名称", field: "loginName", width: 300},
                {title: "名称", field: "enName", width: 300},
                {
                    title: "是否可修改", width: 60, field: "sex", formatter: function (value, row, index) {
                    if (value == 1) {
                        return "男";
                    }
                    if (value == 2) {
                        return "女";
                    }
                }
                },
                {title: "名称", field: "birth", width: 300},
                {title: "说明", field: "email", width: 300},
                {title: "说明", field: "phone", width: 300},
                {title: "说明", field: "address", width: 300},
                {title: "说明", field: "status", width: 300},
                {
                    title: "是否可修改", width: 60, field: "isFinal", formatter: function (value, row, index) {
                    if (value == 1) {
                        return "是";
                    }
                    if (value == 2) {
                        return "否";
                    }
                }
                },
                {
                    title: "创建时间", width: 100, field: "createTime", formatter: function (value, row, index) {
                    date = new Date(value);
                    timeStr = date.getFullYear() + "-" + date.getMonth() + "-" + date.getDay() + " " + date.getHours() + ":" + date.getMinutes();
                    return timeStr;
                }
                },
                {
                    title: "更新时间", width: 100, field: "updateTime", formatter: function (value, row, index) {
                    date = new Date(value);
                    timeStr = date.getFullYear() + "-" + date.getMonth() + "-" + date.getDay() + " " + date.getHours() + ":" + date.getMinutes();
                    return timeStr;
                },
                },
            ]],
        });
    },
    init_edit_view: function () {

    },
    init_password_view: function () {

    },
    save: function () {

    },
    update: function (data) {

    },
    delete: function (id) {

    },
    init_password: function (id, oldPassword, newPassword) {

    },
    forbiddenUser: function (id) {

    },


};
$(document).ready(function () {

});