package com.udemy.aopdemo.dao;

import com.udemy.aopdemo.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

    private String name;
    private String serviceCode;

    public void addAccount(Account theAccount, boolean vipFlag) {

        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");

    }

    public boolean addSilly() {

        System.out.println(getClass() + ": xDDD");

        return true;

    }

    public boolean doWork() {

        System.out.println(getClass() + ": doWork....");

        return true;
    }

    public String getName() {
        System.out.println("Getting the name...");
        return name;
    }

    public void setName(String name) {
        System.out.println("Name will be set...");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println("Getting the service code...");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println("ServiceCode will be set...");
        this.serviceCode = serviceCode;
    }
}