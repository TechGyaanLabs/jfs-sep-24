package com.careerit.ljdbc;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class Employee {

        private String name;
        private int age;
        private String city;
        private List<String> skills;
        private Address address;
}
