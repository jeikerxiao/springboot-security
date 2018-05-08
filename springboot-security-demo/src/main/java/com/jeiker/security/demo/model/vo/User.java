package com.jeiker.security.demo.model.vo;

import lombok.Data;

import java.util.List;

@Data
public class User {
    private String name;
    private Integer age;
    private Sex sex;
    private Integer birthday;
    private Double weight;
    private List<String> hobby;

    public User(String name, Integer age, Sex sex, Integer birthday, Double weight, List<String> hobby) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.birthday = birthday;
        this.weight = weight;
        this.hobby = hobby;
    }
}
