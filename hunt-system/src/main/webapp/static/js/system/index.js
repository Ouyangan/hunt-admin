$(document).ready(function () {
    $("#tab").tabs({
        fit: true,
        border: true,
    });
    $(".tab-btn").click(function () {
        var title = $(this).find('div:first').text();
        var href = $(this).find('div:first').attr("href");
        if ($('#tab').tabs('exists', title)) {
            $('#tab').tabs('select', title);
        } else {
            $('#tab').tabs('add', {
                fit: true,
                title: title,
                closable: true,
                href: href,
            });
            return false;
        }
    })
})