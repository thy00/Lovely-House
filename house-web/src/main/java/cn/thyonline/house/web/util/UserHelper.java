package cn.thyonline.house.web.util;

import cn.thyonline.house.common.result.ResultMsg;
import cn.thyonline.house.web.form.UserForm;
import org.apache.commons.lang3.StringUtils;

/**
 * @Description:
 * @Author: Created by thy
 * @Date: 2018/6/29 21:11
 */
public class UserHelper {
    public static ResultMsg validate(UserForm accout){
        if (StringUtils.isBlank(accout.getEmail())){
            return ResultMsg.errorMsg("Email 错误");
        }

        if (StringUtils.isBlank(accout.getName())){
            return ResultMsg.errorMsg("名字 错误");
        }
        if (StringUtils.isBlank(accout.getPasswd())||!accout.getPasswd().equals(accout.getConfirmPasswd())){
            return ResultMsg.errorMsg("密码 错误");
        }
        if (accout.getPasswd().length()<6){
            return ResultMsg.errorMsg("密码长度需大于6位");
        }
        return ResultMsg.successMsg("注册成功");

    }
}
