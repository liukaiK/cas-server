package com.unicom.smartcity.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author liukai
 */
@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(@RequestParam(value = "client_id") String clientId, Model model) {
        model.addAttribute("clientId", clientId);
        return "login";
    }


}
