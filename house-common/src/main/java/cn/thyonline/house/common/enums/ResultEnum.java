package cn.thyonline.house.common.enums;

import lombok.Getter;

/**
 * @Description:返回前端信息枚举
 * @Author: Created by thy
 * @Date: 2018/6/29 19:50
 */
@Getter
public enum ResultEnum {

    ;
    private Integer code;
    private String message;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.message = msg;
    }
}
