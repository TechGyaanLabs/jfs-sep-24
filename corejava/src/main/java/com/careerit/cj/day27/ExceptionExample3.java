package com.careerit.cj.day27;

import java.util.List;

record User(String username, String password, String email, String phone) {
}
public class ExceptionExample3 {

    public static void main(String[] args) {

            try {
                User user = login("krishna", "krish@123");
                System.out.println("Welcome "+user.username());
            }catch (BadCredentitalsException e){
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
    }

    public static User login(String username, String password) throws BadCredentitalsException{

        List<User> users = loadUsers();
        for(User user:users) {
            if(user.username().equals(username) && user.password().equals(password)) {
                return user;
            }
        }
        throw new BadCredentitalsException("Bad credentials");
    }

    public static List<User> loadUsers(){
        return List.of(new User("admin", "admin@123", "admin@gmail.com", "9876543210"),
                new User("krish", "krish@123", "krish@gmail.com", "9876543211"));
    }

}
