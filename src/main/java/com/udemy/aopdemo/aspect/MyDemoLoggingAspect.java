package com.udemy.aopdemo.aspect;

import com.udemy.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @AfterReturning(pointcut = "execution(* com.udemy.aopdemo.dao.AccountDAO.findAccounts(..))", returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("--> ADVICE: Executing @AfterReturning advice on method: " + method);
        System.out.println("--- Modifying result...");
        // modify the result
        convertAccountNamesToUpperCase(result);
        System.out.println("--- Modified result is: " + result);
        System.out.println("<--");
    }

    private void convertAccountNamesToUpperCase(List<Account> result) {
        for(Account account : result) {
            account.setName(account.getName().toUpperCase());
            account.setLevel(account.getLevel().toUpperCase());
        }
    }

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
