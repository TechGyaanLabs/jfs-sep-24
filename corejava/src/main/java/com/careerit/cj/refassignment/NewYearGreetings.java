package com.careerit.cj.refassignment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewYearGreetings implements GreetingService {

    @Override
    public String greet(String username) {
        return "Happy New Year " + username;
    }
}
