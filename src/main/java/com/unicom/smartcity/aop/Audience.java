package com.unicom.smartcity.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Audience {

    public Audience() {
//        System.out.println("切面初始化");
    }

    @Before("execution(* org.springframework.beans.factory.BeanFactory.getBean(..))")
    public void log() {
        try {
            System.out.println("要获取bean了");
//            System.out.println("要上场了*************");
//            proceedingJoinPoint.proceed();
//            System.out.println("退场了*************");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

}
