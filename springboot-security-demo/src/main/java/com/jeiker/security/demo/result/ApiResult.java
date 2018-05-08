package com.jeiker.security.demo.result;

public class ApiResult {

    public static <T> Result<T> success() {
        Result<T> result = new Result<>();
        result.setCode(ErrorMsg.SUCCESS.getCode());
        result.setMessage(ErrorMsg.SUCCESS.getMessage());
        result.setData(null);
        return result;
    }

    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.setCode(ErrorMsg.SUCCESS.getCode());
        result.setMessage(ErrorMsg.SUCCESS.getMessage());
        result.setData(data);
        return result;
    }

    public static <T> Result<T> failure() {
        Result<T> result = new Result<>();
        result.setCode(ErrorMsg.FAILURE.getCode());
        result.setMessage(ErrorMsg.FAILURE.getMessage());
        result.setData(null);
        return result;
    }

    public static <T> Result<T> failure(ErrorMsg msg) {
        Result<T> result = new Result<>();
        result.setCode(msg.getCode());
        result.setMessage(msg.getMessage());
        result.setData(null);
        return result;
    }

    public static <T> Result<T> failure(String msg) {
        Result<T> result = new Result<>();
        result.setCode(ErrorMsg.FAILURE.getCode());
        result.setMessage(msg);
        result.setData(null);
        return result;
    }

    public static <T> Result<T> failure(Integer code, String message) {
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMessage(message);
        result.setData(null);
        return result;
    }
}
