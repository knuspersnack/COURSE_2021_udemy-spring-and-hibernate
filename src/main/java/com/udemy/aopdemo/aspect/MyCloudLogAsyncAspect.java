package com.udemy.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(0)
public class MyCloudLogAsyncAspect {
    @Before("com.udemy.aopdemo.aspect.PointcutContainer.matchesAllMethodsExceptGettersAndSetters()")
    public void logToCloudAsynch() {
        System.out.println("--> ADVICE: Logging to CLoud in async fashion <--");
    }

}
