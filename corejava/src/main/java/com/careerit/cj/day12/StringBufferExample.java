package com.careerit.cj.day12;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

record Customer(String name, double amount, LocalDate dueDate) {
}

public class StringBufferExample {

    public static void main(String[] args) {

        List<Customer> customerList = new ArrayList<>();
        customerList.add(new Customer("Krish", 4500, LocalDate.of(2024, 10, 10)));
        customerList.add(new Customer("Manoj", 4500, LocalDate.of(2024, 10, 10)));
        customerList.add(new Customer("Charan", 4500, LocalDate.of(2024, 10, 10)));
        customerList.add(new Customer("Kiran", 4500, LocalDate.of(2024, 10, 10)));
        customerList.add(new Customer("Jayesh", 4500, LocalDate.of(2024, 10, 10)));
        customerList.add(new Customer("Suresh", 4500, LocalDate.of(2024, 10, 10)));
        customerList.add(new Customer("John", 4500, LocalDate.of(2024, 10, 10)));
        customerList.add(new Customer("Saleem", 4500, LocalDate.of(2024, 10, 10)));
        customerList.add(new Customer("Aadhya", 4500, LocalDate.of(2024, 10, 10)));

        long startTime = System.currentTimeMillis();
        for (Customer customer : customerList) {
            /*String message = "Hi " + customer.name() + ", Your bill amount is " + customer.amount()
                    + " and due date is " + customer.dueDate() + ".";*/
            StringBuffer sb = new StringBuffer();
            sb.append("Hi ")
                    .append(customer.name())
                    .append(", your bill amount is ")
                    .append(customer.amount())
                    .append(" and due date is ")
                    .append(customer.dueDate())
                    .append(".");
            System.out.println(sb.toString());
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }

}
