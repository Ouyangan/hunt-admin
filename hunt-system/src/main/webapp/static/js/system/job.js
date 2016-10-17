job_tool = {
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
}
$(document).ready(function () {
    job_tool.init_main_view();
});