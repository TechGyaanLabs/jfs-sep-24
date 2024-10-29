package com.careerit.cj.refassignment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BirthdayGreetings implements GreetingService {

    @Override
    public String greet(String username) {
        return "Happy Birthday " + username;
    }
}
