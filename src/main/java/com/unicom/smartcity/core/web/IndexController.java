package com.unicom.smartcity.core.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author liukai
 */
@Controller
public class IndexController {

    private static final Log logger = LogFactory.getLog("com.unicom.smartcity.web.IndexController");

    @GetMapping("/index")
    public String index() {
        logger.info("***********************************************************************");
        return "index";
    }

}
