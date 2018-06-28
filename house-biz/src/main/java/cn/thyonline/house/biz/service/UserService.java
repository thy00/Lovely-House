package cn.thyonline.house.biz.service;

import cn.thyonline.house.common.pojo.User;
import cn.thyonline.house.biz.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: Created by thy
 * @Date: 2018/6/28 15:34
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> selectUsers() {
        return userMapper.selectUsers();
    }
}
