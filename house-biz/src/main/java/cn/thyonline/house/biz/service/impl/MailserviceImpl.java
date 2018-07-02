package cn.thyonline.house.biz.service.impl;

import cn.thyonline.house.biz.mapper.UserMapper;
import cn.thyonline.house.biz.service.Mailservice;
import cn.thyonline.house.common.pojo.User;
import cn.thyonline.house.common.pojo.UserExample;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: Created by thy
 * @Date: 2018/7/1 21:48
 */
@Service
public class MailserviceImpl implements Mailservice {

    //设置本地缓存
    private final Cache<String, String> registerCache =
            CacheBuilder.newBuilder().maximumSize(100).expireAfterAccess(15, TimeUnit.MINUTES)
                    .removalListener(new RemovalListener<String, String>() {//过期时触发操作
                        @Override
                        public void onRemoval(RemovalNotification<String, String> notification) {
                            String email = notification.getValue();
                            UserExample example=new UserExample();
                            UserExample.Criteria criteria = example.createCriteria();
                            criteria.andEmailEqualTo(email);
                            User account = (User) userMapper.selectByExample(example);
                            if (account!=null&&!account.getEnable()){
                                userMapper.deleteByPrimaryKey(account.getId());//如果存在且未激活则删除
                            }
                        }
                    }).build();

    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private UserMapper userMapper;

    @Value("${spring.mail.username}")
    private String FROM;

    @Value("${domain.name}")
    private String DOMAINNAME;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void sendMail(String mailName, String url, String email) {
        SimpleMailMessage message=new SimpleMailMessage();
        message.setFrom(FROM);
        message.setTo(email);
        message.setText(url);
        message.setCc(FROM);
        mailSender.send(message);
    }

    /**
     * 1、缓存key-email的关系（随机字符串）
     * 2、借助spring mail 发送邮件
     * 3、借助异步框架进行异步操作
     * @param email
     */
    @Async
    public void registerNotify(String email) {
        String randomKey=RandomStringUtils.randomAlphabetic(10);//10位
        registerCache.put(randomKey,email);//绑定
        String url="http://"+DOMAINNAME+"/accounts/verify?key="+randomKey;
        sendMail("好房网平台激活邮件",url,email);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean enable(String key) {
        String email = registerCache.getIfPresent(key);
        if (StringUtils.isEmpty(email)){
            return false;
        }
        User updateUser = new User();
        updateUser.setEmail(email);
        updateUser.setEnable(true);
        UserExample example=new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andEmailEqualTo(email);
        userMapper.updateByExampleSelective(updateUser,example);
        return true;
    }
}
