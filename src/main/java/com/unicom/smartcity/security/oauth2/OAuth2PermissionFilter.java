package com.unicom.smartcity.security.oauth2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author liukai
 */
@Slf4j
public class OAuth2PermissionFilter extends OncePerRequestFilter {

    private final AntPathMatcher antPathMatcher = new AntPathMatcher();

    private final static String OAUTH_AUTHORIZE = "/oauth/authorize";


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {


        if (isAuthorizeUrl(request)) {
            //TODO 判断权限


            checkPermission(request, response);

        }

        filterChain.doFilter(request, response);

    }

    private boolean isAuthorizeUrl(HttpServletRequest request) {
        return antPathMatcher.match(request.getContextPath() + OAUTH_AUTHORIZE, request.getRequestURI());
    }

    private void checkPermission(HttpServletRequest request, HttpServletResponse response) {

        log.info("判断权限");

    }


}
