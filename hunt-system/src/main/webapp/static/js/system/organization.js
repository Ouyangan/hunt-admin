$(function () {
    var data_json = new Array();
    $.ajax({
        method: 'post',
        url: '/organization/select',
        async: false,
        dataType: 'json',
        success: function (result) {
            if (result.code == 10000) {
                for (var i in result.data) {
                    var row_data = {
                        id: i.id,
                        name: i.name,
                        description: i.description,
                        createTime: i.createTime,
                        updateTime: i.updateTime,
                        createBy: i.createBy,
                        updateBy: i.updateBy,
                    };
                    data_json.push(row_data);
                }
            } else {
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
        idFiled: "id",
        treeField: "name",
        fitColumns: true,
        animate: true,
        toolbar: '#tool-bar',
        singleSelect: true,
        checkOnSelect: true,
        fit: true,
        border: false,
        striped: true,
        pagePosition: "bottom",
        pageNumber: 1,
        pageSize: 15,
        pageList: [15, 30, 45, 60],
        pagination: true,
        columns: [[
            {title: "id", field: "id", width: 20},
            {title: "名称", field: "name", width: 120},
            {title: "说明", field: "description", width: 200},
            {title: "创建时间", field: "createTime", width: 100},
            {title: "更新时间", field: "updateTime", width: 100},
            {title: "创建人", field: "createBy", width: 100},
            {title: "更新人", field: "updateBy", width: 100},
        ]],
    })
});