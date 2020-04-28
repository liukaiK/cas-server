package com.unicom.smartcity.security.oauth2;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * OAuth2资源服务
 *
 * @author liukai
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
@Configuration
@EnableResourceServer
public class OAuth2ResourceServerConfigurer extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/oauth2/api/**").authorizeRequests().anyRequest().authenticated();
    }

}
