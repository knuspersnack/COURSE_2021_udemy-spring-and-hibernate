package com.udemy.aopdemo;

import com.udemy.aopdemo.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterThrowingDemoApp {
    public static void main(String[] args) {
        // read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
        List<Account> accounts = null;
        try {
            boolean forceException = true;
            accounts = accountDAO.findAccounts(forceException);
        } catch (Exception exc) {
            System.out.println("EXCEPTION caught: " + exc);
        }

        System.out.println("Main Program: After Throwing demo app!");
        System.out.println("Accounts: " + accounts);

        // close the context
        context.close();
    }
}
