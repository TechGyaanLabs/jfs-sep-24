package com.careerit.cj.day28;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;


@ToString
@Getter
@Setter
public class Contact {

        private String name;
        private String email;
        private String phone;
        private Map<String,Object> address;


}
