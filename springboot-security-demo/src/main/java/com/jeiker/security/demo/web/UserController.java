package com.jeiker.security.demo.web;

import com.fasterxml.jackson.annotation.JsonView;
import com.jeiker.security.demo.model.vo.UserVo;
import com.jeiker.security.demo.result.ApiResult;
import com.jeiker.security.demo.result.ErrorMsg;
import com.jeiker.security.demo.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @PostMapping
    public Result add(@Valid @RequestBody UserVo userVo, BindingResult errors) {
        log.info(userVo.toString());
        if (errors.hasErrors()) {
            String errorStr = errors.getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.joining("; "));
            log.error(errorStr);
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
