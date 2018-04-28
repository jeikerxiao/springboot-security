package com.jeiker.security.demo.web;

import com.jeiker.security.demo.exception.BusinessException;
import com.jeiker.security.demo.result.ApiResult;
import com.jeiker.security.demo.result.ErrorMsg;
import com.jeiker.security.demo.result.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/success")
    public Result hello() {
        Map<String, String> massage = Collections.singletonMap("message", "hello");
        return ApiResult.success(massage);
    }

    @GetMapping("/failure")
    public Result hi() {
        return ApiResult.failure(ErrorMsg.FAILURE);
    }

    @GetMapping("/test")
    public Result test() {
        throw new BusinessException("业务异常");
    }
}
