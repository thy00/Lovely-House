package cn.thyonline.house.common.utils;

import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

import java.nio.charset.Charset;

/**
 * @Description:密码加密工具
 * @Author: Created by thy
 * @Date: 2018/6/30 23:01
 */
public class HashUtil {
    //编写MD5
    private static final HashFunction FUNCTION=Hashing.md5();
    //编写盐，防止被暴力破解
    private static final String SALT="thyonline.cn";
    public static String encryPassword(String password){
        HashCode hashCode = FUNCTION.hashString(password + SALT, Charset.forName("UTF-8"));
        return hashCode.toString();
    }
}
