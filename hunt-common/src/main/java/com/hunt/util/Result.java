package com.hunt.util;

/**
 * @Author ouyangan
 * @Date 2016/10/8/13:40
 * @Description
 */
public class Result {
    private int code;
    private String msg;
    private Object data = "";


    public Result(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result() {
    }

    public static Result instance(int code, String msg) {
        return new Result(code, msg);
    }

    public static Result success() {
        return new Result(ResponseCode.success.getCode(), ResponseCode.success.getMsg());
    }

    public static Result success(Object data) {
        return new Result(ResponseCode.success.getCode(), ResponseCode.success.getMsg(), data);
    }

    public static Result error() {
        return new Result(ResponseCode.error.getCode(), ResponseCode.error.getMsg());
    }

    public static Result error(String msg) {
        return new Result(ResponseCode.error.getCode(), msg);
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
