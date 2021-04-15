package com.udemy.aopdemo.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    @Pointcut("execution(* com.udemy.aopdemo.dao.*.*( ..))")
    private void matchesAllMethodsInDaoPackage(){}

    @Pointcut("execution(* com.udemy.aopdemo.dao.*.get*( ..))")
    private void matchesGetterMethodsInDaoPackage(){}

    @Pointcut("execution(* com.udemy.aopdemo.dao.*.set*( ..))")
    private void matchesSetterMethodsInDaoPackage(){}

    @Pointcut("matchesAllMethodsInDaoPackage() && !(matchesGetterMethodsInDaoPackage() || matchesSetterMethodsInDaoPackage())")
    private void matchesAllMethodsExceptGettersAndSetters(){}

    // The pointcut is injected
    @Before("matchesAllMethodsExceptGettersAndSetters()")
    public void beforeAddAccoundAdvice() {
        System.out.println("--> ADVICE: Executing @Before advice on addAccount() <--");
    }

    // The pointcut is injected
    @Before("matchesAllMethodsExceptGettersAndSetters()")
    public void performApiAnalystics() {
        System.out.println("--> ADVICE: Perform API anylytics <--");
    }


    @After("execution(* *(..))")
    public void afterAddAccoundAdvice() {
        System.out.println("-------------------------------");
    }


}
