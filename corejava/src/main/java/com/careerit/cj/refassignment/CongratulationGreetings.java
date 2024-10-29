package com.careerit.cj.refassignment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CongratulationGreetings implements GreetingService {

    private String message;

    @Override
    public String greet(String username) {
        return "Congratulation " + username;
    }
}
