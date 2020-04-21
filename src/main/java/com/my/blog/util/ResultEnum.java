package com.my.blog.util;

/**
 * @author jiaomingyu5778@gmail.com
 * @date 2020/4/9 19:28
 */
public enum ResultEnum {


    //这里是可以自己定义的，方便与前端交互即可
    UNKNOWN_ERROR(-1,"未知错误"),
    SUCCESS(200,"成功"),
    USER_NOT_EXIST(1,"用户不存在"),
    USER_IS_EXISTS(2,"用户已存在"),
    DATA_IS_NULL(3,"数据为空"),
    PARAMETER_ERROR(4, "参数错误"),
    LOGIN_ERROR(5, "用户名或密码错误"),
    NOT_GET_CAPTCHA(1007, "请先获取校验码"),
    CAPTCHA_VERIFY_FAILED(1008, "校验码未校验通过")
    ;
    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
