package com.careerit.sfb.di.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserManager {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("user-bean.xml");
        UserController userController = context.getBean(UserController.class);
        userController.showUsers();
    }
}
