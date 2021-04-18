package com.udemy.aopdemo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {


    @Around("execution(* com.udemy.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String method = proceedingJoinPoint.getSignature().toShortString();
        System.out.println("--> ADVICE: Executing @Around advice on method: " + method);

        long begin = System.currentTimeMillis();
        Object result = null;
        try {
            result = proceedingJoinPoint.proceed();
        } catch(Exception ex) {
            boolean handleException = true;
            if(handleException) {
                System.out.println("--- !ERROR!: " + ex.getMessage());
                result = "Major accident! But no worries, you will be fine!";
            } else {
                System.out.println("--- !ERROR!: " + ex.getMessage());
                throw ex;
            }
        }
        long end = System.currentTimeMillis();
        long duration = end - begin;

        System.out.println("--- Duration: " + duration / 1000.0 + " seconds");

        System.out.println("<--");
        return result;
    }

}
