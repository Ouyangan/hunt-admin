package com.hunt.util;

/**
 * @Author ouyangan
 * @Date 2016/10/8/14:22
 * @Description
 */
public enum PlatformCode {

    web(1, "web"),
    android(2, "安卓"),
    ios(3, "IOS"),
    other(4, "其他");

    private int code;
    private String msg;

    PlatformCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
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
