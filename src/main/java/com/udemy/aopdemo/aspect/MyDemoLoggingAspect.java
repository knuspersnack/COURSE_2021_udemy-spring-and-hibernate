package com.udemy.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @After("execution(* com.udemy.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint){
        String method = joinPoint.getSignature().toShortString();
        System.out.println("--> ADVICE: Executing @After advice on method: " + method);

        System.out.println("<--");
    }

    @AfterThrowing(pointcut = "execution(* com.udemy.aopdemo.dao.AccountDAO.findAccounts(..))", throwing = "exc")
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable exc) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("--> ADVICE: Executing @AfterThrowing advice on method: " + method);

        System.out.println("--- The Exception is: " + exc);
        System.out.println("<--");
    }

}
