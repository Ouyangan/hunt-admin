$(function () {
    $("#organization").datagrid({
        url: '',
        columns: [[
            {field: 'itemid', title: 'Item ID', rowspan: 2, width: 80, sortable: true},
            {field: 'productid', title: 'Product ID', rowspan: 2, width: 80, sortable: true},
            {title: 'Item Details', colspan: 4}
        ], [
            {field: 'listprice', title: 'List Price', width: 80, align: 'right', sortable: true},
            {field: 'unitcost', title: 'Unit Cost', width: 80, align: 'right', sortable: true},
            {field: 'attr1', title: 'Attribute', width: 100},
            {field: 'status', title: 'Status', width: 60}
        ]]
    })
});