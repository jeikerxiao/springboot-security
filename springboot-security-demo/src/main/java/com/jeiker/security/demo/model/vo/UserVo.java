package com.jeiker.security.demo.model.vo;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class UserVo {

    public interface SimpleView {}
    public interface DetailView extends SimpleView {}

    @JsonView(SimpleView.class)
    @NotNull(message = "id不能为空")
    private String id;

    @JsonView(SimpleView.class)
    @NotBlank(message = "用户名不能为空")
    private String username;

    @JsonView(DetailView.class)
    @NotEmpty(message = "密码不能为空")
    private String password;

    private Date birthday;


}
