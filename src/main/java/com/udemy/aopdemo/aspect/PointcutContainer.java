package com.udemy.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointcutContainer {
    @Pointcut("execution(* com.udemy.aopdemo.dao.*.add( ..))")
    public void matchesAllMethodsInDaoPackage(){}

    @Pointcut("execution(* com.udemy.aopdemo.dao.*.get*( ..))")
    public void matchesGetterMethodsInDaoPackage(){}

    @Pointcut("execution(* com.udemy.aopdemo.dao.*.set*( ..))")
    public void matchesSetterMethodsInDaoPackage(){}

    @Pointcut("matchesAllMethodsInDaoPackage() && !(matchesGetterMethodsInDaoPackage() || matchesSetterMethodsInDaoPackage())")
    public void matchesAllMethodsExceptGettersAndSetters(){}

}
