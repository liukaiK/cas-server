package com.unicom.smartcity.security.form;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.unicom.smartcity.enums.ResponseCode;
import com.unicom.smartcity.pojo.SimpleResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Slf4j
@Component(value = "formAuthenticationSuccessHandler")
public class FormAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private final RequestCache requestCache = new HttpSessionRequestCache();

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {

        String targetUrl = decideTargetUrl(request, response);

        log.info("AuthenticationSuccess targetUrl: {}", targetUrl);

        response.setContentType(MediaType.APPLICATION_JSON.toString());
        PrintWriter writer = response.getWriter();
        writer.write(objectMapper.writeValueAsString(new SimpleResponse(ResponseCode.SUCCESS.getCode(), targetUrl)));
        writer.close();
    }


    public String decideTargetUrl(HttpServletRequest request, HttpServletResponse response) {
        SavedRequest savedRequest = requestCache.getRequest(request, response);
        if (savedRequest == null) {
            String indexUrl = request.getContextPath() + "/";
            return indexUrl;
        } else {
            return savedRequest.getRedirectUrl();
        }
    }


}
