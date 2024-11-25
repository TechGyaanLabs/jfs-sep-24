package com.careerit.sfb.di.java;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {


    @Bean
    public UserDao userDao(){
        return new UserDao();
    }

    @Bean
    public UserService userService(){
        UserService userService = new UserService();
        userService.setUserDao(userDao());
        return userService;
    }

    @Bean
    public UserController userController(){
        UserController userController = new UserController();
        userController.setUserService(userService());
        return userController;
    }
}
