package com.udemy.mvc.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {

    //--- setup logger
    private Logger myLogger = Logger.getLogger(getClass().getName());

    //--- setup pointcut decalrations
    @Pointcut("execution(* com.udemy.mvc.controller.*.*(..))")
    private void forControllerPackage() {

    }

    @Pointcut("execution(* com.udemy.mvc.service.*.*(..))")
    private void forServicePackage() {

    }

    @Pointcut("execution(* com.udemy.mvc.repository.*.*(..))")
    private void forRepositoryPackage() {

    }


    @Pointcut("forControllerPackage() || forServicePackage() || forRepositoryPackage()")
    private void forAppFlow() {
    }

    //--- setup advices
    //add @Before advice
    //If a method from controller package or from service package or from repository package is executed
    //the method call will be logged
    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint) {

        String method = joinPoint.getSignature().toShortString();
        myLogger.info("-->");
        //display method we are calling
        myLogger.info("--- Advice: @Before -> calling method: " + method);

        //display the arguments to the method
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            myLogger.info("--- Argument passed: " + arg);
        }

        myLogger.info("<--");
    }

    //add @AfterReturning advice
    @AfterReturning(pointcut = "forAppFlow()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        String method = joinPoint.getSignature().toShortString();
        myLogger.info("-->");
        myLogger.info("--- Advice: @AfterReturning -> calling method: " + method);
        myLogger.info("--- Result: " + result);
        myLogger.info("<--");
    }

}


