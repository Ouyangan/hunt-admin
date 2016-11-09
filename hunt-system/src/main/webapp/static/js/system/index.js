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
                        location = "/"
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
            if (href == '/druid/index.html') {
                var content = '<iframe scrolling="true" frameborder="0"  src=' + href + ' style="width:100%;height:100%;"></iframe>';
                $('#tab').tabs('add', {
                    tabWidth: 100,
                    tabHeight: 35,
                    fit: true,
                    title: title,
                    closable: true,
                    content: content,
                    border: true,
                    onLoadError: function () {
                        $('#tab').tabs('add', {
                            tabWidth: 100,
                            tabHeight: 35,
                            fit: true,
                            title: '系统错误',
                            closable: true,
                            href: "/404.jsp",
                            border: true,
                        });
                    },
                });
            } else if (href == '/swagger-ui.html') {
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
                        $('#tab').tabs('add', {
                            tabWidth: 100,
                            tabHeight: 35,
                            fit: true,
                            title: '系统错误',
                            closable: true,
                            href: "/404.jsp",
                            border: true,
                        });
                    },
                });
            }
            return false;
        }
    });

});