package com.bi.springboot;

import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

public class CustomLoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    public CustomLoginSuccessHandler(String defaultUrl) {
        setDefaultTargetUrl(defaultUrl);
    }


}
