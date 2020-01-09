package com.unicom.smartcity.config.security.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

/**
 * @author liukai
 */
@Slf4j
@Component("restAuthenticationProvider")
public class RestAuthenticationProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        log.info("{}", authentication);
        RestUsernamePasswordClientIdAuthenticationToken usernamePasswordAuthenticationToken = new RestUsernamePasswordClientIdAuthenticationToken(authentication.getPrincipal(), authentication.getCredentials(), ((RestUsernamePasswordClientIdAuthenticationToken) authentication).getClientId(), authentication.getAuthorities());
        return usernamePasswordAuthenticationToken;
    }


    @Override
    public boolean supports(Class<?> authentication) {
        return (RestUsernamePasswordClientIdAuthenticationToken.class.isAssignableFrom(authentication));
    }


}
