$(document).ready(function () {
    init();
    $(".select-btn").click(function () {
        init();
    });
    $(".save-btn").click(function () {
        $("#organization-save").dialog({
            title: '新增组织',
            closable: true,
            width: 700,
            height: 300,
            cache: false,
            modal: true,
            resizable: false,
            draggable: false,
        })
    });
    $(".update-btn").click(function () {
        init();
    });
    $(".delete-btn").click(function () {
        init();
    });
});
function init() {
    var data_json = '';
    $.ajax({
        method: 'post',
        url: '/organization/select',
        async: false,
        dataType: 'json',
        success: function (result) {
            if (result.code == 10000) {
                data_json = result.data;
                console.log(data_json);
            }
            else {
                $.messager.show({
                    title: '系统提示',
                    msg: result.msg,
                    timeout: 2000,
                    showType: 'slide'
                });
            }
        },
    });
    $("#organization").treegrid({
        data: data_json,
        idField: "id",
        nodeId: 'id',
        treeField: 'name',
        fitColumns: true,
        toolbar: '#tool-bar',
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
}
