package com.unicom.smartcity.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.unicom.smartcity.enums.ResponseCode;
import com.unicom.smartcity.pojo.SimpleResponse;
import com.unicom.smartcity.util.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.csrf.CsrfException;
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
public class AccessDeniedHandler implements org.springframework.security.web.access.AccessDeniedHandler {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        log.error("访问没有权限", accessDeniedException);

        if (accessDeniedException instanceof CsrfException) {
            ResponseUtil.response(response, objectMapper.writeValueAsString(new SimpleResponse(ResponseCode.ACCESS_DENIED.getCode(), ResponseCode.ACCESS_DENIED.getMessage())));
        }

    }

}
