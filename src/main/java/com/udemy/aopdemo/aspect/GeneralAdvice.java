package com.udemy.aopdemo.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GeneralAdvice {
    @After("execution(* *(..))")
    public void afterAddAccoundAdvice() {
        System.out.println("-------------------------------");
    }
}
