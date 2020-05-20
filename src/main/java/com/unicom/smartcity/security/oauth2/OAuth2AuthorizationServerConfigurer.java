package com.unicom.smartcity.security.oauth2;

import com.unicom.smartcity.service.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.provider.token.TokenStore;

/**
 * OAuth2 授权服务
 *
 * @author liukai
 */
@Configuration
@EnableAuthorizationServer
public class OAuth2AuthorizationServerConfigurer extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private TokenStore tokenStore;

    @Autowired
    private PasswordService passwordService;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("gis")
                .secret(passwordService.getDefaultPassword())
                .autoApprove(true)
                .redirectUris("http://127.0.0.1:8081/login/oauth2/code/cas", "http://localhost:8081/login/oauth2/code/cas")
                .accessTokenValiditySeconds(300)
                .authorizedGrantTypes(AuthorizationGrantType.AUTHORIZATION_CODE.getValue())
                .scopes("USER_INFO")
                .resourceIds("cas-resource-server");
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        endpoints.tokenStore(tokenStore)
                .pathMapping("/oauth/token", "/oauth/token")
                .pathMapping("/oauth/authorize", "/oauth/authorize");
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) {

    }

}
