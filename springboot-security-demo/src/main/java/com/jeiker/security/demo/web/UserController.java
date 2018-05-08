package com.jeiker.security.demo.web;

import com.fasterxml.jackson.annotation.JsonView;
import com.jeiker.security.demo.model.vo.Sex;
import com.jeiker.security.demo.model.vo.User;
import com.jeiker.security.demo.model.vo.UserVo;
import com.jeiker.security.demo.result.ApiResult;
import com.jeiker.security.demo.result.ErrorMsg;
import com.jeiker.security.demo.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
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

    public static void main(String[] args) {

        /**
         private String name;
         private Integer age;
         private Sex sex;
         private Integer birthday;
         private Double weight;
         private List<String> hobby;
         */
        List<User> userList = Arrays.asList(
                new User("A", 12, Sex.MAN, 2011, 60.5, Arrays.asList("swim","running")),
                new User("C", 23, Sex.MAN, 2012, 54.3, Arrays.asList("music","riding")),
                new User("B", 30, Sex.WOMAN, 2010, 48.2, Arrays.asList("swim","programme"))
        );

//        userList.stream()
//                .limit(2)
//                .forEach(System.out::println);
//
//        userList.stream()
//                .skip(2)
//                .forEach(System.out::println);

//        userList.stream()
//                .min(Comparator.comparing(User::getAge))
//                .ifPresent(System.out::println);

//        userList.stream()
//                .map(User::getName)
//                .sorted()
//                .forEach(System.out::println);

        boolean less25 = userList.stream()
                .allMatch(u -> u.getAge() < 35);
        System.out.println(less25);
    }
}
