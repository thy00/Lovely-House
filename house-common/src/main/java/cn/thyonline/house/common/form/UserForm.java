package cn.thyonline.house.common.form;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

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

    private String avatar;

    private MultipartFile avatarFile;

    private Boolean type;

    private Integer agencyId;
}
