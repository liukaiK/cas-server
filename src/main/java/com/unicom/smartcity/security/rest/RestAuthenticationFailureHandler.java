package com.unicom.smartcity.security.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.unicom.smartcity.enums.ResponseCode;
import com.unicom.smartcity.exception.HttpErrorException;
import com.unicom.smartcity.exception.RestLoginException;
import com.unicom.smartcity.pojo.SimpleResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 登录失败处理器
 *
 * @author liukai
 */
@Slf4j
@Component("restAuthenticationFailureHandler")
public class RestAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Autowired
    private ObjectMapper objectMapper;

    private final RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException {
        log.info(exception.getMessage());
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        PrintWriter writer = response.getWriter();
        if (exception instanceof HttpErrorException) {
            writer.write(objectMapper.writeValueAsString(SimpleResponse.failure(ResponseCode.REST_AUTHENTICATION_FAIL)));
        }
        if (exception instanceof RestLoginException) {
            writer.write(objectMapper.writeValueAsString(new SimpleResponse(1231231231, exception.getMessage())));
        }
        writer.close();
    }

}
