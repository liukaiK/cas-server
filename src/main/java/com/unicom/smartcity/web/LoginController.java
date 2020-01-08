package com.unicom.smartcity.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author liukai
 */
@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }


}
