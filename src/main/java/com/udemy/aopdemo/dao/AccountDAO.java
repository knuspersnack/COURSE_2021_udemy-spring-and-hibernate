package com.udemy.aopdemo.dao;

import com.udemy.aopdemo.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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

    public List<Account> findAccounts(boolean forceException) {
        if (forceException) {
            throw new RuntimeException("No soup for you!");
        }

        List<Account> myAccounts = new ArrayList<>();

        Account temp1 = new Account("John", "Silver");
        Account temp2 = new Account("Josh", "Platinum");
        Account temp3 = new Account("Luca", "Gold");

        myAccounts.add(temp1);
        myAccounts.add(temp2);
        myAccounts.add(temp3);

        return myAccounts;
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