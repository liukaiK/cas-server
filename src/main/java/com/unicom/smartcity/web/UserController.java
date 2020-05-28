package com.unicom.smartcity.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liukai
 */
@Slf4j
@RestController
public class UserController {


    @GetMapping("/oauth2/api/user_info")
    public Authentication getUserInfo(@AuthenticationPrincipal Authentication authentication) {


//        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

//        log.info("user: {}", user);

        return authentication;
    }

}
