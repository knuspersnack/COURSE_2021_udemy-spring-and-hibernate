package com.udemy.aopdemo.service;

import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class TrafficFortuneService {

    public String getFortune() {
        //simulate a delay

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //return a fortune
        return "Expect haevy traffic this morning";
    }

    public String getFortune(boolean forceException) {
        if(forceException) {
            throw new RuntimeException("Major accident! Highway is closed!");

        }
        return getFortune();
    }
}
