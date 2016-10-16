role_tool = {
    //初始化数据
    // init_data: function (pageNumber, pageSize) {
    //     var data_json = '';
    //     $.ajax({
    //         data: {
    //             pageNumber: pageNumber,
    //             pageSize: pageSize,
    //         },
    //         method: 'get',
    //         url: '/role/select',
    //         async: false,
    //         dataType: 'json',
    //         success: function (result) {
    //             if (result.code == 10000) {
    //                 data_json = result.data;
    //                 console.log(data_json);
    //             }
    //             else {
    //                 common_tool.messager_show(result.msg);
    //             }
    //         },
    //     });
    //     return data_json;
    // },
    //初始化页面+加载数据
    init_main_view: function () {
        $("#role_grid").datagrid({
            url: "/role/select",
            method:'get',
            idField: "id",
            treeField: 'name',
            fitColumns: true,
            toolbar: '#tool-bar',
            rownumbers: true,
            animate: true,
            singleSelect:true,
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
                {title: "名称", field: "name", width: 300},
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
};
$(document).ready(function () {
    role_tool.init_main_view();
    $(".select-btn").click(function () {
        role_tool.init_main_view();
    });
})