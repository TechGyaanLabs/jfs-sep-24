package com.careerit.sfb.di.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserController {

    @Autowired
    private UserService userService;


    public void showUsers() {
        userService
                .getUserNameInUpperCase()
                .forEach(System.out::println);
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    public UserService getUserService() {
        return userService;
    }
}
