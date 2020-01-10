package com.unicom.smartcity.security.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

/**
 * Rest认证配置配置
 *
 * @author liukai
 */
@Component
public class RestSecurityConfigurer extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    @Autowired
    private AuthenticationProvider restAuthenticationProvider;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AuthenticationFailureHandler restAuthenticationFailureHandler;


    @Override
    public void configure(HttpSecurity http) {
        RestUsernamePasswordAuthenticationFilter restUsernamePasswordAuthenticationFilter = new RestUsernamePasswordAuthenticationFilter();
        restUsernamePasswordAuthenticationFilter.setAuthenticationManager(authenticationManager);
        restUsernamePasswordAuthenticationFilter.setAuthenticationFailureHandler(restAuthenticationFailureHandler);
        http.authenticationProvider(restAuthenticationProvider);
        http.addFilterBefore(restUsernamePasswordAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

    }

}
