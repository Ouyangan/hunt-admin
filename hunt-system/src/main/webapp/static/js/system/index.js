$(document).ready(function () {
    $("#tab").tabs({
        width: 200,
        fit: true,
        border: true,
    });
    $(".easyui-linkbutton").click(function () {
        var title = $(this).text();
        var href = $(this).attr("href");
        if ($('#tab').tabs('exists', title)) {
            $('#tab').tabs('select', title);
        } else {
            if (href == '/druid/index.html') {
                var content = '<iframe scrolling="true" frameborder="0"  src="' + href + '" style="width:100%;height:100%;"></iframe>';
                $('#tab').tabs('add', {
                    tabWidth: 100,
                    tabHeight: 35,
                    fit: true,
                    title: title,
                    closable: true,
                    content: content,
                    border: true,
                });
            } else {
                $('#tab').tabs('add', {
                    tabWidth: 100,
                    tabHeight: 35,
                    fit: true,
                    title: title,
                    closable: true,
                    href: href,
                    border: true,
                });
            }
            return false;
        }
    });

    $("#logout-btn").click(function () {
        $.messager.confirm('确认对话框', "您确认退出系统吗?", function (r) {
            if (r) {
                $.ajax({
                    data: {},
                    method: 'get',
                    url: '/system/logout',
                    async: false,
                    dataType: 'json',
                    success: function (result) {
                        location = "/"
                    },
                });
            }
        });
    });
});