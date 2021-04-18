package com.udemy.mvc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

//For Security
@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //add our users for in memory authentication
        User.UserBuilder users = User.withDefaultPasswordEncoder();
        auth.inMemoryAuthentication().withUser(users.username("john").password("test123").roles("EMPLOYEE"));
        auth.inMemoryAuthentication().withUser(users.username("mary").password("test123").roles("MANAGER"));
        auth.inMemoryAuthentication().withUser(users.username("susan").password("test123").roles("ADMIN"));
    }
}
