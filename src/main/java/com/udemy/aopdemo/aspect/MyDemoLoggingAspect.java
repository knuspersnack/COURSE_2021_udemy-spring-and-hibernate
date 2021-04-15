package com.udemy.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
    @Before("com.udemy.aopdemo.aspect.PointcutContainer.matchesAllMethodsExceptGettersAndSetters()")
    public void beforeAddAccoundAdvice() {
        System.out.println("--> ADVICE: Executing @Before advice on addAccount() <--");
    }

}
