package com.hunt.system.security.geetest;

/**
 * GeetestWeb配置文件
 * 
 *
 */
public class GeetestConfig {

	// 填入自己的captcha_id和private_key
	private static final String geetest_id = "12be88e9f71cb0c9e4272ff4185dad58";
	private static final String geetest_key = "ea738412018c379060d332a03ef6b4be ";

	public static final String getGeetest_id() {
		return geetest_id;
	}

	public static final String getGeetest_key() {
		return geetest_key;
	}

}
