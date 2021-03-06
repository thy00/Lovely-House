package cn.thyonline.house.biz.service;

/**
 * @Description:
 * @Author: Created by thy
 * @Date: 2018/7/1 21:46
 */
public interface Mailservice {

    /**
     * 发送邮件
     * @param mailName
     * @param url
     * @param email
     */
    void sendMail(String mailName, String url, String email);

    /**
     * 异步通知
     * @param email
     */
    void registerNotify(String email);

    /**
     * 验证邮箱
     * @param key
     * @return
     */
    boolean enable(String key);
}
