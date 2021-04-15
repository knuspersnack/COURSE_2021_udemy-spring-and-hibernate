package com.udemy.aopdemo.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
    // this is where we add all of our related advices for logging

    //@Before("execution(public void addAccount())") // <- pointcut (Matches the call of the method with this name)
    //@Before("execution(public void com.udemy.aopdemo.dao.AccountDAO.addAccount())") // <- pointcut (Matches the call of the method from AccountDAO)
    //@Before("execution(public void add*())") // <- pointcut (Matches the call of the method that starts with 'add')
    //@Before("execution(void *())") // <- pointcut (Matches only methods with return type void)
    //@Before("execution(void add*(com.udemy.aopdemo.Account))") // <- pointcut (Matches only methods if the passed parameter is account)
    //@Before("execution(void add*(com.udemy.aopdemo.Account, ..))") // <- pointcut (Matches only methods if the passed parameter are including account )
    //@Before("execution(* add*( ..))") // <- pointcut (Matches only methods with any parameters)
    @Before("execution(* com.udemy.aopdemo.dao.*.*( ..))") // <- pointcut (Matches methods in a given package)
    public void beforeAddAccoundAdvice() {
        System.out.println("--> Executing @Before advice on addAccount() <--");
    }

    @After("execution(* *(..))")
    public void afterAddAccoundAdvice() {
        System.out.println("-------------------------------");
    }


}
