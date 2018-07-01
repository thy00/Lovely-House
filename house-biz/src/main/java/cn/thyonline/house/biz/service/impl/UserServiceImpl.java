package cn.thyonline.house.biz.service.impl;

import cn.thyonline.house.biz.mapper.UserMapper;
import cn.thyonline.house.biz.service.FileService;
import cn.thyonline.house.biz.service.Mailservice;
import cn.thyonline.house.biz.service.UserService;
import cn.thyonline.house.common.form.UserForm;
import cn.thyonline.house.common.pojo.User;
import cn.thyonline.house.common.pojo.UserExample;
import cn.thyonline.house.common.utils.BeanHelper;
import cn.thyonline.house.common.utils.HashUtil;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: Created by thy
 * @Date: 2018/6/28 15:34
 */
@Service
public class UserServiceImpl implements UserService {

    //设置本地缓存
    private final Cache<String,String> registerCache=CacheBuilder.newBuilder()
            .maximumSize(100)
            .expireAfterAccess(15,TimeUnit.MINUTES)
            .removalListener(new RemovalListener<String, String>() {//过期时触发操作
                @Override
                public void onRemoval(RemovalNotification<String, String> notification) {
//                    userMapper.del
                }
            }).build();

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private FileService fileService;

    @Value("${domain.name}")
    private String DOMAINNAME;
    @Autowired
    private Mailservice mailservice;

    public List<User> selectUsers() {
        UserExample example=new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.getAllCriteria();
        return userMapper.selectByExample(example);
    }

    /**
     * 1、插入数据库，非激活；密码加盐md5；保存头像
     * 2、生成key，绑定email
     * 3、发送邮件(异步操作)
     * @param account
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean addAccount(UserForm account) {
        //密码加密
        account.setPasswd(HashUtil.encryPassword(account.getPasswd()));
        //上传图片
        List<String> path = fileService.getImgPath(Lists.newArrayList(account.getAvatarFile()));
        if (!path.isEmpty()){
            account.setAvator(path.get(0));
        }
        //设置默认值
        User user = new User();
        BeanUtils.copyProperties(account,user);
        BeanHelper.setDefaultProp(user,User.class);
        BeanHelper.onInsert(account);
        user.setEnable(false);
        user.setCreateTime(new Date());
        //插入数据库
        userMapper.insert(user);
        //发送邮件
        registerNotify(user.getEmail());
        return false;
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
        mailservice.sendMail("好房网平台激活邮件",url,email);
    }
}
