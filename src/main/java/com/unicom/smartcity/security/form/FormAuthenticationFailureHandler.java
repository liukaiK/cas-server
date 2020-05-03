package com.unicom.smartcity.security.form;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.unicom.smartcity.enums.ResponseCode;
import com.unicom.smartcity.pojo.SimpleResponse;
import com.unicom.smartcity.util.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author liukai
 */
@Slf4j
@Component
public class FormAuthenticationFailureHandler implements AuthenticationFailureHandler {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {

        log.error("认证错误", exception);


        if (exception instanceof BadCredentialsException) {
            ResponseUtil.response(response, objectMapper.writeValueAsString(new SimpleResponse(ResponseCode.AUTHENTICATION_FAIL.getCode(), ResponseCode.AUTHENTICATION_FAIL.getMessage())));
        }

    }

}
