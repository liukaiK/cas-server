package com.unicom.smartcity.security.rest;

import com.unicom.smartcity.exception.BadClientIdException;
import com.unicom.smartcity.exception.HttpErrorException;
import com.unicom.smartcity.exception.RestLoginException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录失败处理器
 *
 * @author liukai
 */
@Slf4j
@Component("restAuthenticationFailureHandler")
public class RestAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        if (exception instanceof BadClientIdException) {

        }

        if (exception instanceof RestLoginException) {
            log.info(exception.getMessage());
        }

        if (exception instanceof HttpErrorException) {
            log.info(exception.getMessage());
        }
        
    }

}
