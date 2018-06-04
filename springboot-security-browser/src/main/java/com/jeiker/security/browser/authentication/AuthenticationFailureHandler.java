package com.jeiker.security.browser.authentication;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

/**
 * Description: 认证成功处理
 * Created by jeikerxiao on 2018/6/4 下午4:56
 */
@Component("authenticationFailureHandler")
@Slf4j
public class AuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

}
