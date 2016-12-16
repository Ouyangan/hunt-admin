$(document).ready(function () {
    $("#logout-btn").click(function () {
        $.messager.confirm('确认对话框', "您确认退出系统吗?", function (r) {
            if (r) {
                $.ajax({
                    data: {},
                    method: 'get',
                    url: getRootPath() + '/system/logout',
                    async: false,
                    dataType: 'json',
                    success: function (result) {
                        location = getRootPath();
                    },
                });
            }
        });
    });
    $(".easyui-linkbutton").click(function () {
        var title = $(this).text();
        var href = $(this).attr("href");
        if ($('#tab').tabs('exists', title)) {
            $('#tab').tabs('select', title);
        } else {
            if ((href.indexOf('druid/index.html') != -1)) {
                var content = '<iframe scrolling="true" frameborder="0"  src="' + href + '" style="width:100%;height:100%;"></iframe>';
                $('#tab').tabs('add', {
                    tabWidth: 100,
                    tabHeight: 35,
                    fit: true,
                    title: title,
                    closable: true,
                    content: content,
                    border: true,
                    onLoadError: function () {
                        $('#tab').tabs('close',title)
                        $('#tab').tabs('add', {
                            tabWidth: 100,
                            tabHeight: 35,
                            fit: true,
                            title: '404',
                            closable: true,
                            href: getRootPath()+"/error/notFound",
                            border: true,
                        });
                    },
                });
            } else if (href.indexOf('swagger-ui.html') != -1) {
                window.open(href)
            }
            else {
                $('#tab').tabs('add', {
                    tabWidth: 100,
                    tabHeight: 35,
                    fit: true,
                    title: title,
                    closable: true,
                    href: href,
                    border: true,
                    onLoadError: function () {
                        $('#tab').tabs('close',title)
                        $('#tab').tabs('add', {
                            tabWidth: 100,
                            tabHeight: 35,
                            fit: true,
                            title: '404',
                            closable: true,
                            href: getRootPath()+"/error/notFound",
                            border: true,
                        });
                    },
                });
            }
            return false;
        }
    });

});