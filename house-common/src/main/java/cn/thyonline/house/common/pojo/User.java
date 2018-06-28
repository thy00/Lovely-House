package cn.thyonline.house.common.pojo;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

/**
 * @Description:
 * @Author: Created by thy
 * @Date: 2018/6/28 10:08
 */
@Data
public class User {
    private Long id;

    private String email;

    private String phone;

    private String name;

    private String passwd;

    private String confirmPasswd;

    private Integer type;//普通用户1，经纪人2

    private Date createTime;

    private Integer enable;

    private String  avatar;

    private MultipartFile avatarFile;

    private String newPassword;

    private String key;

    private Long   agencyId;

    private String aboutme;

    private String agencyName;
}
