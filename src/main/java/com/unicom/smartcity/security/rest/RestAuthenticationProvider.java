package com.unicom.smartcity.security.rest;

import com.unicom.smartcity.exception.BadClientIdException;
import com.unicom.smartcity.exception.HttpErrorException;
import com.unicom.smartcity.security.oauth2.OAuthClientDetails;
import com.unicom.smartcity.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;

/**
 * @author liukai
 */
@Slf4j
@Component("restAuthenticationProvider")
public class RestAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private ClientDetailsService clientDetailsService;

    @Autowired
    private LoginService loginService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        log.info("{}", authentication);
        RestUsernamePasswordClientIdAuthenticationToken restUsernamePasswordClientIdAuthenticationToken = (RestUsernamePasswordClientIdAuthenticationToken) authentication;


        String clientId = restUsernamePasswordClientIdAuthenticationToken.getClientId();
        ClientDetails clientDetails;

        try {
            clientDetails = clientDetailsService.loadClientByClientId(clientId);
        } catch (ClientRegistrationException e) {
            throw new BadClientIdException("clientId 错误:" + clientId);
        }

        String loginUrl = ((OAuthClientDetails) clientDetails).getLoginUrl();

        String username = restUsernamePasswordClientIdAuthenticationToken.getPrincipal().toString();

        String password = restUsernamePasswordClientIdAuthenticationToken.getCredentials().toString();


        try {
            loginService.login(loginUrl, username, password);
        } catch (RestClientException e) {
            log.error("调用登录接口{}失败 ", loginUrl, e);
            throw new HttpErrorException("调用登录接口{}失败 " + loginUrl);
        }


        return new RestUsernamePasswordClientIdAuthenticationToken(username, password, clientId, restUsernamePasswordClientIdAuthenticationToken.getAuthorities());
    }


    @Override
    public boolean supports(Class<?> authentication) {
        return (RestUsernamePasswordClientIdAuthenticationToken.class.isAssignableFrom(authentication));
    }


}
