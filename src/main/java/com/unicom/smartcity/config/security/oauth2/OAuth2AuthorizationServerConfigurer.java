package com.unicom.smartcity.config.security.oauth2;

import com.unicom.smartcity.service.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.CompositeTokenGranter;
import org.springframework.security.oauth2.provider.TokenGranter;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * OAuth2 授权服务
 *
 * @author liukai
 */
@Configuration
@EnableAuthorizationServer
public class OAuth2AuthorizationServerConfigurer extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private AuthenticationManager authenticationManager;

//    @Autowired
//    private WebResponseExceptionTranslator oauth2ResponseExceptionTranslator;

    @Autowired
    private PasswordService passwordService;

//    @Autowired
//    private AuthenticationEntryPoint OAuth2AuthenticationEntryPoint;

//    @Autowired
//    private DataSource dataSource;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("community")
                .secret(passwordService.getDefaultPassword())
                .authorizedGrantTypes("authorization_code")
                .redirectUris("http://www.community.com")
                .accessTokenValiditySeconds(-1)
                .scopes("userInfo")
                .autoApprove(true);
    }


    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        endpoints.authenticationManager(authenticationManager);
        endpoints.tokenGranter(tokenGranter(endpoints));
//        endpoints.exceptionTranslator(oauth2ResponseExceptionTranslator);
//        endpoints.tokenEnhancer(getTokenEnhancer());
        endpoints.tokenStore(new InMemoryTokenStore());
    }

//    public TokenEnhancer getTokenEnhancer() {
//        TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
//        TokenEnhancer responseTokenEnhancer = new OAuth2TokenEnhancer();
//        tokenEnhancerChain.setTokenEnhancers(Collections.singletonList(responseTokenEnhancer));
//        return tokenEnhancerChain;
//    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) {
        security.allowFormAuthenticationForClients();
//        security.authenticationEntryPoint(OAuth2AuthenticationEntryPoint);
//        security.checkTokenAccess("permitAll()");
    }

    private TokenGranter tokenGranter(final AuthorizationServerEndpointsConfigurer endpoints) {
        List<TokenGranter> granters = new ArrayList<>(Collections.singletonList(endpoints.getTokenGranter()));
//        granters.add(new OAuth2SmsCodeTokenGranter(authenticationManager, endpoints.getTokenServices(), endpoints.getClientDetailsService(), endpoints.getOAuth2RequestFactory()));
        return new CompositeTokenGranter(granters);
    }


}
