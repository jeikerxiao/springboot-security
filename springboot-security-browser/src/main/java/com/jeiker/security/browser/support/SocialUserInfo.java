package com.jeiker.security.browser.support;

import lombok.Data;

/**
 * Description: springboot-security
 * Created by jeikerxiao on 2018/6/4 下午5:12
 */
@Data
public class SocialUserInfo {

    private String providerId;
    private String providerUserId;
    private String nickname;
    private String headImg;

}
