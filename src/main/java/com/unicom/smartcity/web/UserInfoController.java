package com.unicom.smartcity.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liukai
 */
@Slf4j
@RequestMapping("/v1")
@RestController
public class UserInfoController {

//    @GetMapping("/userinfo")
//    public Authentication getUserInfo(HttpServletRequest request, Authentication authentication) {
//
//        log.info("{}调用了userinfo接口", request.getRequestURI());
//        return authentication;
//    }


    @GetMapping("/userinfo")
    public Map<String, Object> getUserInfo(HttpServletRequest request, Authentication authentication) {
        Map<String, Object> map = new HashMap<>();
        log.info("{}调用了userinfo接口", request.getRequestURI());
        map.put("username", authentication.getPrincipal().toString());
        return map;
    }

}
