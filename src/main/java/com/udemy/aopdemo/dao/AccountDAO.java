package com.udemy.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

    public void addAccount() {

        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");

    }

    public boolean addSilly() {

        System.out.println(getClass() + ": xDDD");

        return true;

    }
}