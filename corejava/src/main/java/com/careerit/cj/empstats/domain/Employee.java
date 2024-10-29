package com.careerit.cj.empstats.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Employee {
        @JsonProperty("employee_id")
        private long empno;
        private String ename;
        private long mgr;
        private String job;
        private double salary;
        private String deptno;
        private List<String> projects;
}
