package com.careerit.sfb.di.annotations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.careerit.sfb.di.java")
public class UserManager {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(UserManager.class);
        UserController userController = context.getBean(UserController.class);
        userController.showUsers();
    }
}
