//package com.unicom.smartcity.listener;
//
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.springframework.web.context.ContextLoaderListener;
//
//import javax.servlet.ServletContextEvent;
//
//public class SpringServletContextListener extends ContextLoaderListener {
//
//    private Log logger = LogFactory.getLog(SpringServletContextListener.class);
//
//    @Override
//    public void contextInitialized(ServletContextEvent event) {
//        logger.debug("spring 初始化");
//        super.contextInitialized(event);
//        logger.debug("spring 初始化完毕");
//    }
//
//}
