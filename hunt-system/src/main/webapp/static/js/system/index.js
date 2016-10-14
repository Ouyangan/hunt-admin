$(function () {
    $("#tab").tabs({
        fit: true,
        border: true,
    });
    $(".tab-btn").click(function () {
        var title = $(this).find('a:first').text();
        var href = $(this).find('a:first').attr("href");
        if ($('#tab').tabs('exists', title)) {
            $('#tab').tabs('select', title);
            return false;
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