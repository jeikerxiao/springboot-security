package com.jeiker.security.demo.result;

public enum ErrorMsg {

    SUCCESS(1,"成功"),
    FAILURE(0,"失败"),

    LOGIN_FAIL(101,"登录失败"),
    LOGOUT_SUCCESS(104,"登出成功"),
    USER_NOT_FOUND(102,"未注册用户"),
    USER_DISABLED(103,"无效用户"),
    NO_LOGIN(105,"未登录"),
    VERIFY_CODE_ERROR(106,"验证码错误"),
    SYSTEM_ERROR(100,"系统错误");

    private Integer code;
    private String message;

    public Integer getCode(){
        return code;
    }
    public String getMessage(){
        return message;
    }

    ErrorMsg(Integer code, String message){
        this.code = code;
        this.message = message;
    }
}
