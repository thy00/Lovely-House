package cn.thyonline.house.biz.service.impl;

import cn.thyonline.house.biz.service.Mailservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: Created by thy
 * @Date: 2018/7/1 21:48
 */
@Service
public class MailserviceImpl implements Mailservice {
    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String FROM;

    @Override
    public void sendMail(String mailName, String url, String email) {
        SimpleMailMessage message=new SimpleMailMessage();
        message.setFrom(FROM);
        message.setTo(email);
        message.setText(url);
        mailSender.send(message);
    }
}
