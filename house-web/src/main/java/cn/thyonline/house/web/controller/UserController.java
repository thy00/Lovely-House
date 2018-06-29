package cn.thyonline.house.web.controller;

import cn.thyonline.house.biz.service.UserService;
import cn.thyonline.house.common.pojo.User;
import cn.thyonline.house.common.result.ResultMsg;
import cn.thyonline.house.web.form.UserForm;
import cn.thyonline.house.web.util.UserHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
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

    @GetMapping("/")
    public List<User> list(){
        return userService.selectUsers();
    }


    /**
     * 注册提交：1、注册验证 2、发送邮件 3、验证失败重定向到注册页面 4、验证成功转跳到成功页面
     * 注册页获取：account对象是否为空判断是否为提交
     * @param account
     * @param modelMap
     * @return
     */
    @PostMapping("/accounts/register")
    public String register(UserForm account, ModelMap modelMap){
        //提交到注册页
        if (account==null||account.getName()==null){
            return "/user/accounts/register";
        }
        //验证表单信息
        ResultMsg resultMsg = UserHelper.validate(account);
//        if ()
        return null;
    }
}
