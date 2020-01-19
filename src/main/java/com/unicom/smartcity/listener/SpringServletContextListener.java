package com.unicom.smartcity.listener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.context.ContextLoaderListener;

import javax.servlet.ServletContextEvent;

public class SpringServletContextListener extends ContextLoaderListener {

    private Log logger = LogFactory.getLog(this.getClass());

    @Override
    public void contextInitialized(ServletContextEvent event) {
        logger.info("spring 初始化");
        super.contextInitialized(event);
        logger.info("spring 初始化完毕");
    }

}
