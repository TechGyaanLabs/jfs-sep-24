package com.careerit.cj.day14;

import com.careerit.cj.day13.Player;

import java.util.List;

public class EmployeeManager {

    public static void main(String[] args) {

        Employee emp1 = new Employee(10001, "Krish", "Dev", 45000);
        Employee emp2 = new Employee(10001, "Krish", "Qa", 45000);
        Employee emp3 = new Employee(10001, "Krish", "Dev", 35000);
        Employee emp4 = new Employee(10001, "Krish", "Qa", 25000);
        Employee emp5 = new Employee(10001, "Krish", "Dev", 55000);

        List<Employee> empList = List.of(emp1, emp2, emp3, emp4, emp5);

        // > 50K increment salary by 30 otherwise increment salary by 50%

        for(Employee emp: empList) {
                if(emp.getSalary() > 50000){
                    double incSalary = emp.getSalary() + emp.getSalary() * 0.3;
                    emp.setSalary(incSalary);
                }else{
                    double incSalary = emp.getSalary() + emp.getSalary() * 0.5;
                    emp.setSalary(incSalary);
                }
        }

        for(Employee emp:empList){
            System.out.println(emp);
            System.out.println("-".repeat(30));
        }
        System.out.println(empList);
    }
}
