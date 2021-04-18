package com.udemy.aopdemo;

import com.udemy.aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AroundDemoApp {
    public static void main(String[] args) {
        // read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

        System.out.println("Main Program: Around demo app!");

        System.out.println("Calling getFortune()....");

        String data = trafficFortuneService.getFortune();

        System.out.println("My Fortune is: " + data);

        System.out.println("Fortune fulfilled");
        // close the context
        context.close();
    }
}
