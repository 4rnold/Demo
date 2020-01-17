package com.example.springbootdemo.mybatis.T7_Test_Mybatis_TypeHandler.entity;

import lombok.Getter;

/**
 * 希望数据库保存状态码
 */
@Getter
public enum  UserStatus {
    LOGIN(200,"已登录"),
    LOGOUT(300,"已登出");


    private Integer code;
    private String msg;

    UserStatus(Integer code, String msg) {

        this.code = code;
        this.msg = msg;
    }

    public static UserStatus getUserStatusByCode(Integer code) {
        UserStatus[] values = UserStatus.values();
        for (UserStatus value : values) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return null;

    }

}
