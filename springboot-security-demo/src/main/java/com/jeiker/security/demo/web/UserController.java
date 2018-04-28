package com.jeiker.security.demo.web;

import com.fasterxml.jackson.annotation.JsonView;
import com.jeiker.security.demo.model.vo.UserVo;
import com.jeiker.security.demo.result.ApiResult;
import com.jeiker.security.demo.result.ErrorMsg;
import com.jeiker.security.demo.result.Result;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @PostMapping
    public Result add(@Valid @RequestBody UserVo userVo, BindingResult errors) {
        log.info(userVo.toString());
        if (errors.hasErrors()) {
            errors.getAllErrors().forEach(e -> log.info(e.getDefaultMessage()));
            String errorStr = "";
            return ApiResult.failure(ErrorMsg.FAILURE.getCode(), errorStr);
        }
        userVo.setId("1");
        return ApiResult.success(userVo);
    }

    @GetMapping("/{id:\\d+}")
    @JsonView(UserVo.SimpleView.class)
    public Result get() {
        UserVo userVo = new UserVo();
        userVo.setId("1");
        userVo.setUsername("xiao");
        userVo.setPassword("12341234");
        userVo.setBirthday(new Date());
        return ApiResult.success(userVo);
    }

}
