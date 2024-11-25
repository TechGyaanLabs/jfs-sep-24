package com.careerit.sfb.di.java;

public class UserController {

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
