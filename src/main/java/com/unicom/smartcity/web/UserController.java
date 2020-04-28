package com.unicom.smartcity.web;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {


    @GetMapping("/oauth2/api/userinfo")
    public User getUserInfo() {

        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

}
