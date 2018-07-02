package cn.thyonline.house.web.controller;

import cn.thyonline.house.biz.service.UserService;
import cn.thyonline.house.common.pojo.User;
import cn.thyonline.house.common.result.ResultMsg;
import cn.thyonline.house.common.form.UserForm;
import cn.thyonline.house.web.util.UserHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description:
 * @Author: Created by thy
 * @Date: 2018/6/28 15:31
 */
@Controller
@RequestMapping("/accounts")
public class UserController {

    @Autowired
    private UserService userService;

//    @GetMapping("/")
//    public List<User> list(){
//        return userService.selectUsers();
//    }


    /**
     * 注册提交：1、注册验证 2、发送邮件 3、验证失败重定向到注册页面 4、验证成功转跳到成功页面
     * 注册页获取：account对象是否为空判断是否为提交
     * @param account
     * @param modelMap
     * @return
     */
    @RequestMapping("/register")
    public String register(UserForm account, ModelMap modelMap){
        //提交到注册页
        if (account==null||account.getName()==null){
            return "/user/accounts/register";
        }
        //验证表单信息
        ResultMsg resultMsg = UserHelper.validate(account);
        if (resultMsg.isSuccess()&&userService.addAccount(account)){
            modelMap.put("email",account.getEmail());
            return "/user/accounts/registerSubmit";
        }else {
            return "redirect:/accounts/register?"+resultMsg.asUrlParams();
        }
    }

    /**
     *
     * @param key
     * @return
     */
    @GetMapping("/verify")
    public String verify(String key){
        boolean result=userService.enable(key);
        if (result){
            return "redirect:/index?"+ResultMsg.successMsg("激活成功").asUrlParams();
        }else {
            return "redirect:/accounts/register?"+ResultMsg.errorMsg("激活失败，请确认注册链接是否过期");
        }
    }
}
