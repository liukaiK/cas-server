package com.unicom.smartcity.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author liukai
 */
@Slf4j
@RestController
public class RedirectController {

    @Autowired
    private TokenEndpoint tokenEndpoint;

    /**
     * @param clientId
     * @param principal 当前访问资源的应用
     * @throws HttpRequestMethodNotSupportedException
     */
    @GetMapping("/redirect")
    public void redirect(@RequestParam(value = "client_id") String clientId, Principal principal) throws HttpRequestMethodNotSupportedException {
        log.info("当前访问资源的应用:{}", principal);


        ResponseEntity<OAuth2AccessToken> OAuth2AccessTokenResponseEntity = tokenEndpoint.postAccessToken(principal, null);


    }


}
