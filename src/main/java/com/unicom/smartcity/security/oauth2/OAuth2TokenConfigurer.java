package com.unicom.smartcity.security.oauth2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

/**
 * 配置token存储和JWT
 *
 * @author liukai
 */
@Configuration
public class OAuth2TokenConfigurer {

    @Bean
    public TokenStore tokenStore() {
        return new InMemoryTokenStore();
    }

}
