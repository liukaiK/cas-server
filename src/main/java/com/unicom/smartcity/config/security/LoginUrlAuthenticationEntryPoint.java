package com.unicom.smartcity.config.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author liukai
 */
@Slf4j
public class LoginUrlAuthenticationEntryPoint extends org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint {

    public LoginUrlAuthenticationEntryPoint(String loginFormUrl) {
        super(loginFormUrl);
    }

    @Override
    protected String determineUrlToUseForThisRequest(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) {
        String queryString = request.getQueryString();
        String redirect = super.determineUrlToUseForThisRequest(request, response, exception);
        return UriComponentsBuilder.fromPath(redirect).query(queryString).toUriString();
    }

}
