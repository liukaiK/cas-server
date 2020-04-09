package com.unicom.smartcity.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author liukai
 */
@Controller
public class LoginController {

    /**
     * 跳转到登录页面
     *
     * @param clientId 在系统中认证过的应用的clientId
     */
    @GetMapping("/login")
    public String login(@RequestParam(value = "client_id", required = false) String clientId, Model model) {
        if (StringUtils.isEmpty(clientId)) {

        }
        model.addAttribute("clientId", clientId);
        return "login";
    }


}
