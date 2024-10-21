package com.careerit.cj.day25;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
class UserDetails{
    private String username;
    private String password;
    private String email;
    private String phone;
    private String role;
}
public class UserLoginApplication {

    public static void main(String[] args) {

    }

    public UserDetails login(String email,String password){
        Map<String,UserDetails> map = getUserMap();
        UserDetails user = map.get(email);
        if(user != null && StringUtils.equals(user.getPassword(), password)){
            return user;
        }
        throw new IllegalArgumentException("Invalid username or password");
    }

    public Map<String,UserDetails> getUserMap(){
        List<UserDetails> users = getExistingUsers();
        Map<String,UserDetails> map = new HashMap<>();
        for(UserDetails user:users){
            map.put(user.getEmail(), user);
        }
        return  map;
    }

    public List<UserDetails> getExistingUsers() {
        return List.of(
                new UserDetails("krish", "krish@123", "krish@gmail.com", "9876543210", "admin"),
                new UserDetails("Charan", "charan@123", "charan@gmail.com", "9876543210", "user"),
                new UserDetails("Rajesh", "rajesh@123", "rajesh@gmail", "9876543210", "user")
                );
    }

}
