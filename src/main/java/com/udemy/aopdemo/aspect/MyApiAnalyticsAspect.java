package com.udemy.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyApiAnalyticsAspect {
    @Before("com.udemy.aopdemo.aspect.PointcutContainer.matchesAllMethodsExceptGettersAndSetters()")
    public void performApiAnalystics() {
        System.out.println("--> ADVICE: Perform API anylytics <--");
    }
}
