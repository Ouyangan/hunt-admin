package system;

import org.omg.CORBA.UNKNOWN;

/**
 * @Author ouyangan
 * @Date 2016/10/8/13:41
 * @Description
 */
public enum ResponseCode {
    success(10000, "操作成功"),
    error(20000, "操作失败"),
    unknown_account(20001, "账户不存在"),
    forbidden_account(20002, "账户已禁用"),
    password_incorrect(20003, "密码错误"),
    unauthorized(20004, "无操作权限"),
    unauthenticated(20004, "未登录"),
    param_format_error(30001, "参数格式错误"),
    missing_parameter(30002,"缺少参数");

    private int code;
    private String msg;

    ResponseCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "ResponseCode{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
