package cn.thyonline.house.web.controller;

import cn.thyonline.house.common.pojo.User;
import cn.thyonline.house.biz.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @Description:
 * @Author: Created by thy
 * @Date: 2018/6/28 16:21
 */
@Controller
public class HelloController {

//    @Autowired
//    private UserService userService;
//    @GetMapping("/hello")
//    public String hello(ModelMap modelMap){
//        List<User> users = userService.selectUsers();
//        User user = users.get(0);
//        modelMap.put("user",user);
//        return "hello";
//    }

    @GetMapping("/index")
    public String index(){
        return "homepage/index";
    }
}
