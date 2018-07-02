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



    @Autowired
    private UserMapper userMapper;
    @Autowired
    private FileService fileService;
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
            account.setAvatar(path.get(0));
        }
        //设置默认值
        User user = new User();
        BeanUtils.copyProperties(account,user);
        BeanHelper.setDefaultProp(user,User.class);
        BeanHelper.onInsert(user);
        user.setEnable(false);
        //插入数据库，先校样邮箱是否注册
        UserExample example=new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andEmailEqualTo(user.getEmail());
        List<User> users = userMapper.selectByExample(example);
        if (!users.isEmpty()){
            return false;
        }
        userMapper.insert(user);
        //发送邮件
        mailservice.registerNotify(user.getEmail());
        return true;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean enable(String key) {
        boolean result=mailservice.enable(key);
        return false;
    }
}
