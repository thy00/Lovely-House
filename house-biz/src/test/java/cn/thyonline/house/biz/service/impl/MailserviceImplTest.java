package cn.thyonline.house.biz.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Description:
 * @Author: Created by thy
 * @Date: 2018/7/2 13:25
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MailserviceImplTest {

    @Autowired
    private MailserviceImpl mailservice;

    @Test
    public void sendMail() {
        mailservice.sendMail("TEST","TEST","977585756@qq.com");

    }

    @Test
    public void registerNotify() {
    }
}
