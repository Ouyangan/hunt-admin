//右下角显示消息
common_tool = {
    messager_show: function (msg) {
        $.messager.show({
            title: '系统提示',
            msg: msg,
            timeout: 2000,
            showType: 'slide'
        });
    },
    timestampToDateTime: function (value) {
        date = new Date(value);
        timeStr = date.getFullYear() + "-" + (date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1) + "-" + date.getDate() + " " + (date.getHours() < 10 ? '0' + date.getHours() : date.getHours()) + ":" + (date.getMinutes() < 10 ? '0' + date.getMinutes() : date.getMinutes()) + ":" + (date.getSeconds() < 10 ? '0' + date.getSeconds() : date.getSeconds());
        return timeStr;
    },
}
function getRootPath() {
    var curWwwPath = window.document.location.href;
    var pathName = window.document.location.pathname;
    var pos = curWwwPath.indexOf(pathName);
    var localhostPatht = curWwwPath.substring(0, pos);
    var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1)
    return (localhostPatht + projectName);
}
