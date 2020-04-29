package com.unicom.smartcity.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author liukai
 */
@Slf4j
@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        log.info("user: {}", user);
        return "index";
    }

}
