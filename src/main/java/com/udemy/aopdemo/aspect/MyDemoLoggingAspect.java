package com.udemy.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
    @Before("com.udemy.aopdemo.aspect.PointcutContainer.matchesAllMethodsExceptGettersAndSetters()")
    public void beforeAddAccoundAdvice(JoinPoint theJoinPoint) {
        System.out.println("--> ADVICE: Executing @Before advice on addAccount()");

        //display the method signature
        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
        System.out.println("--- Method Siganture: " + methodSignature);

        //display method arguments
        Object[] joinPointArgs = theJoinPoint.getArgs();
        for(Object arg:joinPointArgs){
            System.out.println("--- Arguments: " + arg.toString());
//            if(arg instanceof Account) {
//                Account account = (Account) arg;
//                System.out.println("--- Account: " + account);
//            }
        }

        System.out.println("<--");
    }

}
