package cn.thyonline.house.web.controller;

import cn.thyonline.house.biz.service.UserService;
import cn.thyonline.house.common.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description:
 * @Author: Created by thy
 * @Date: 2018/6/28 15:31
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 注册提交：1、注册验证 2、发送邮件 3、验证失败重定向到注册页面 4、验证成功转跳到成功页面
     * 注册页获取：account对象是否为空判断是否为提交
     * @param account
     * @param modelMap
     * @return
     */
    @PostMapping("/accounts/register")
    public String register(User account, ModelMap modelMap){
        return null;
    }
}
