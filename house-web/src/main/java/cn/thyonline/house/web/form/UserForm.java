package cn.thyonline.house.web.form;

import cn.thyonline.house.common.pojo.User;
import cn.thyonline.house.common.result.ResultMsg;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

/**
 * @Description:用户表单校样
 * @Author: Created by thy
 * @Date: 2018/6/29 19:24
 */
@Data
public class UserForm {

    private Long id;

    private String name;

    private String phone;

    private String email;

    private String aboutme;

    private String passwd;

    private String confirmPasswd;

    private String newPassword;

    private String avator;

    private MultipartFile avatarFile;

    private Boolean type;

    private Integer agencyId;
}
