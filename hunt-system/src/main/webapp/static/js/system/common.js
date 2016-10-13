//右下角显示消息
function messager_show(msg) {
    $.messager.show({
        title: '系统提示',
        msg: msg,
        timeout: 2000,
        showType: 'slide'
    });
}