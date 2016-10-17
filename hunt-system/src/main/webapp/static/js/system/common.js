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
    messager_confirm: function (msg) {
        $.messager.confirm('确认对话框', msg, function (r) {
            if (r) {
                return true;
            }
        });
    }
}
