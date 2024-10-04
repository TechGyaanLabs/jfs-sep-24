package com.careerit.cj.day14;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Employee {

    private long empno;
    private String name;
    private String job;
    private double salary;

}
