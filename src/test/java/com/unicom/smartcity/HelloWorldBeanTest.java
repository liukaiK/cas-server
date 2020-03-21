package com.unicom.smartcity;

import com.unicom.smartcity.aop.Audience;
import com.unicom.smartcity.config.RootConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class, Audience.class})
public class HelloWorldBeanTest {

//    @Autowired
//    private HelloWorldBean helloWorldBean;
//
//    @Autowired
//    private Performance performance;
//
//    @Autowired
//    private ApplicationContext applicationContext;
//
//
//    @Test
//    public void sayHelloWorld() {
////        System.out.println("helloWorldBean.sayHelloWorld() = " + helloWorldBean.sayHelloWorld());
//
//
//        performance.perform("上场了");
//
//        Audience bean = applicationContext.getBean(Audience.class);
//
////        System.out.println("bean = " + bean);
//    }


}