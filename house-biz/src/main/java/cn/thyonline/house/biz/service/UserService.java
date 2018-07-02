package cn.thyonline.house.biz.service;

import cn.thyonline.house.common.form.UserForm;
import cn.thyonline.house.common.pojo.User;
import cn.thyonline.house.biz.mapper.UserMapper;
import cn.thyonline.house.common.pojo.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: Created by thy
 * @Date: 2018/6/28 15:34
 */
public interface UserService {


    List<User> selectUsers();

    /**
     * 用户注册
     * @param account
     * @return
     */
    boolean addAccount(UserForm account);

    /**
     * 验证邮箱
     * @param key
     * @return
     */
    boolean enable(String key);
}
