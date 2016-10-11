$(function () {
    var data_json = new Array();
    $.ajax({
        method: 'post',
        url: '/organization/select',
        async: false,
        dataType: 'json',
        success: function (result) {
            data_json = result.data;
            // for (var i in result.data) {
            //     var row_data = {
            //         id: i.id,
            //         name: i.name,
            //         description: i.description,
            //         isFinal: i.isFinal,
            //         createTime: i.createTime,
            //         updateTime: i.updateTime,
            //         createBy: i.createBy,
            //         updateBy: i.updateBy
            //     };
            //     data_json.push(row_data);
            // }
        },
    });
    $("#organization").datagrid({
        url: "/organization/select",
        method: 'post',
        idFiled: "id",
        // treeField: "name",
        fitColumns: true,
        animate: true,
        toolbar: '#tool-bar',
        singleSelect: true,
        collapsible: true,
        checkOnSelect: true,
        rownumbers: true,
        fit: true,
        border: false,
        pagePosition: "bottom",
        pageNumber: 1,
        pageSize: 15,
        pageList: [15, 30, 45, 60],
        pagination: true,
        columns: [[
            {title: "选择", field: "ck",checkbox:true},
            {title: "名称", field: "name", width: 120},
            {title: "说明", field: "description", width: 200},
            {title: "是否可编辑", field: "isFinal", width: 200},
            {title: "创建时间", field: "createTime", width: 100},
            {title: "更新时间", field: "updateTime", width: 100},
            {title: "创建人", field: "createBy", width: 100},
            {title: "更新人", field: "updateBy", width: 100},
        ]],
    })
});