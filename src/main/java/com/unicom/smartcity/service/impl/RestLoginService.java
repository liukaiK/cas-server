package com.unicom.smartcity.service.impl;

import com.unicom.smartcity.exception.RestLoginException;
import com.unicom.smartcity.security.LoginResponse;
import com.unicom.smartcity.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * @author liukai
 */
@Service
public class RestLoginService implements LoginService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void login(String loginUrl, String username, String password) {
        MultiValueMap<String, Object> paramMap = new LinkedMultiValueMap<>();
        paramMap.add("username", username);
        paramMap.add("password", password);
        HttpEntity<MultiValueMap<String, Object>> httpEntity = new HttpEntity<>(paramMap);
        ResponseEntity<LoginResponse> responseEntity = restTemplate.exchange(loginUrl, HttpMethod.POST, httpEntity, LoginResponse.class);

        if (loginFailure(responseEntity)) {
            throw new RestLoginException("登录失败: " + responseEntity.getBody().getMessage());
        }


    }

    private boolean loginFailure(ResponseEntity<LoginResponse> responseEntity) {
        return !"0".equals(responseEntity.getBody().getCode());
    }


}
