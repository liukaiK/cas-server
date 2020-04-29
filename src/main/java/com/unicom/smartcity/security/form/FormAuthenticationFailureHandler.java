package com.unicom.smartcity.security.form;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.unicom.smartcity.enums.ResponseCode;
import com.unicom.smartcity.pojo.SimpleResponse;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author liukai
 */
@Component
public class FormAuthenticationFailureHandler implements AuthenticationFailureHandler {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        PrintWriter writer = response.getWriter();
        writer.write(objectMapper.writeValueAsString(new SimpleResponse(ResponseCode.AUTHENTICATION_FAIL.getCode(), ResponseCode.AUTHENTICATION_FAIL.getMessage())));
        writer.close();
    }

}
