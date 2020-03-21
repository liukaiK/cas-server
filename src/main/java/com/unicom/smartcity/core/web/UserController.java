package com.unicom.smartcity.core.web;

import com.unicom.smartcity.core.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author liukai
 */
@Controller
@RequestMapping("/users")
public class UserController {

    private static final Log logger = LogFactory.getLog("com.unicom.smartcity.web.UserController");

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public String list(Model model) {
        logger.info("/users/list");
        model.addAttribute("userList", userService.list());
        return "user/list";
    }

}
