package com.jeiker.security.demo.web;

import com.fasterxml.jackson.annotation.JsonView;
import com.jeiker.security.demo.model.vo.UserVo;
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
    public UserVo add(@Valid @RequestBody UserVo userVo, BindingResult errors) {
        log.info(userVo.toString());
        if (errors.hasErrors()) {
            errors.getAllErrors().forEach(e -> log.info(e.toString()));
        }
        userVo.setId("1");
        return userVo;
    }

    @GetMapping("/{id:\\d+}")
    @JsonView(UserVo.SimpleView.class)
    public UserVo get() {
        UserVo userVo = new UserVo();
        userVo.setId("1");
        userVo.setUsername("xiao");
        userVo.setPassword("12341234");
        userVo.setBirthday(new Date());
        return userVo;
    }

}
