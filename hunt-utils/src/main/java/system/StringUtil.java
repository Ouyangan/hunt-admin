package system;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * @Author: ouyangan
 * @Date : 2016/10/7
 */
public class StringUtil {
    /**
     * 生成密码
     *
     * @param password 密码
     * @param salt 密码盐
     * @return
     */
    public static String createPassword(String password, String salt) {
        Md5Hash md5Hash = new Md5Hash(password.trim(), salt, 2);
        return md5Hash.toString();
    }
}
