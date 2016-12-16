package com.hunt.system.security.geetest;

/**
 * GeetestWeb配置文件
 */
public class GeetestConfig {

    // 填入自己的captcha_id和private_key
    private static final String geetest_id = "796c2461adf8051c835e4a758a6091f6";
    private static final String geetest_key = "0edad631bed761ab039d8391dd3103ff";

    public static final String getGeetest_id() {
        return geetest_id;
    }

    public static final String getGeetest_key() {
        return geetest_key;
    }

}
