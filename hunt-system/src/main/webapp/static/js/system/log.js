log_tools = {
    init_main_view: function () {
        var method = $("input[name='method']").val();
        var url = $("input[name='url']").val();
        var param = $("input[name='param']").val();
        var result = $("input[name='result']").val();
        $("#log_grid").datagrid({
            url: getRootPath() + "/system/log/list",
            method: 'get',
            idField: "id",
            fitColumns: true,
            toolbar: '#log-tool-bar',
            rownumbers: true,
            animate: true,
            singleSelect: true,
            fit: true,
            border: false,
            pagination: true,
            striped: true,
            pagePosition: "bottom",
            pageNumber: 1,
            pageSize: 30,
            pageList: [30, 60, 90, 120],
            queryParams: {
                method: method,
                url: url,
                param: param,
                result: result,
            },
            frozenColumns: [[
                {title: "选择", field: "ck", checkbox: true},
                {
                    title: "time", field: "createTime", sortable: true, formatter: function (value, row, index) {
                    return common_tool.timestampToDateTime(value);
                }, width: 150
                },
                {title: "method", field: "method", sortable: true, width: 370},
                {title: "url", field: "url", sortable: true, width: 309},
                {title: "param", field: "param", sortable: true, width: 200},
                {title: "duration", field: "duration", sortable: true, width: 100},
                {title: "ip", field: "ip", sortable: true, width: 100},
            ]],
            columns: [[
                {title: "result", field: "result", sortable: true,},
                {title: "userId", field: "userId", sortable: true,},
                {title: "userAgent", field: "userAgent", sortable: true,},
            ]],
        });
    },
    form_clear: function () {
        $("#select_form").form('clear');
        $("#log_grid").datagrid("uncheckAll");
    }
};
$(document).ready(function () {
    log_tools.init_main_view();
    $("#log-flash-btn").click(function () {
        log_tools.form_clear();
        log_tools.init_main_view();
    });
    $("#log-select-btn").click(function () {
        log_tools.init_main_view();
    });
});