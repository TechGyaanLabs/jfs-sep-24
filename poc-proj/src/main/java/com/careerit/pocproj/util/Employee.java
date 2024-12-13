package com.careerit.pocproj.util;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@ToString
public class Employee {

    private int empno;
    private String ename;
    private double salary;
}
