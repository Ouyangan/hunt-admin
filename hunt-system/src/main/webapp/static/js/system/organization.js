$(document).ready(function () {
    init_treegrid();

    $(".save-btn").click(function () {
        init_add_view();
    });
    $(".update-btn").click(function () {
        init_update_view();
    });
    $(".delete-btn").click(function () {
        deleteOrganization();
    });
    $(".select-btn").click(function () {
        init_treegrid();
    });
});

function init_update_view() {
    v
}

//初始化增加页面
function init_add_view() {
    console.log("init add");
    $("#organization_save").dialog({
        title: '新增组织机构',
        iconCls: 'icon-save',
        closable: true,
        width: 900,
        height: 480,
        cache: false,
        modal: true,
        resizable: false,
        'onOpen': function () {
            $("#organization_save_right").treegrid({
                title: '上级组织机构',
                data: init_data(),
            });
        },
        buttons: [
            {
                text: '保存',
                width: 100,
                iconCls: 'icon-save',
                handler: function () {
                    saveOrganization();
                }
            },
            {
                text: '清除',
                width: 100,
                iconCls: 'icon-reload',
                handler: function () {

                }
            },
            {
                text: '取消',
                width: 100,
                iconCls: 'icon-add',
                handler: function () {
                    $("#organization_save").dialog('close');
                }
            }
        ],
    });
}

//初始化页面+加载数据
function init_treegrid() {
    $("#organization").treegrid({
        data: init_data(),
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
//初始化数据
function init_data() {
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
                messager_show(result.msg);
            }
        },
    });
    return data_json;
}

//删除组织机构
function deleteOrganization() {
    var organizationArray = $("#organization").treegrid('getChecked');
    if (organizationArray.length == 0) {
        messager_show("请至少选择一条记录");
    }
    $.ajax({
        data: {
            id: organizationArray[0].id,
        },
        method: 'get',
        url: '/organization/delete',
        async: false,
        dataType: 'json',
        success: function (result) {
            if (result.code == 10000) {
                $("#organization_save").dialog("close");
                init_treegrid();
            }
            else {
                messager_show(result.msg);
            }
        },
    });
}
//保存组织机构
function saveOrganization() {
    // if (!$('#name').validatebox('isValid')) {
    //     messager_show('请输入名称');
    // } else if (!$('#fullName').validatebox('isValid')) {
    //     messager_show('请输入全称');
    // } else if (!$('#description').validatebox('isValid')) {
    //     messager_show('请输入描述');
    // } else if ($("#organization_save_right").treegrid("getChecked").length == 0) {
    //     messager_show('请选择上级组织机构');
    // } else {
    if (!checkValidatebox()) {
        return false;
    }
    var name = $("#name").val();
    var fullName = $("#fullName").val();
    var description = $("#description").val();
    var isFinal = 1;
    var parentId = $("#organization_save_right").treegrid("getChecked")[0].id;
    $.ajax({
        data: {
            name: name,
            fullName: fullName,
            description: description,
            isFinal: isFinal,
            parentId: parentId,
        },
        method: 'post',
        url: '/organization/insert',
        async: false,
        dataType: 'json',
        success: function (result) {
            if (result.code == 10000) {
                $("#organization_save").dialog("close");
                init_treegrid();
            }
            else {
                messager_show(result.msg);
            }
        },
    });
    // }
}

function checkValidatebox() {
    if (!$('#name').validatebox('isValid')) {
        messager_show('请输入名称');
        return false;
    } else if (!$('#fullName').validatebox('isValid')) {
        messager_show('请输入全称');
        return false;
    } else if (!$('#description').validatebox('isValid')) {
        messager_show('请输入描述');
        return false;
    } else if ($("#organization_save_right").treegrid("getChecked").length == 0) {
        messager_show('请选择上级组织机构');
        return false;
    } else {
        return true;
    }
}
