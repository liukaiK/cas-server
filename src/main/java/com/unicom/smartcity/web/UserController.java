package com.unicom.smartcity.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liukai
 */
@Slf4j
@RestController
public class UserController {


    @GetMapping("/oauth2/api/user_info")
    public User getUserInfo() {

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        log.info("user: {}", user);

        return user;
    }

}
