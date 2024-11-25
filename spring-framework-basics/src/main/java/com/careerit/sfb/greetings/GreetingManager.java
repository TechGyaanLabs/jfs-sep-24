package com.careerit.sfb.greetings;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;


@ComponentScan(basePackages = "com.careerit.sfb.greetings")
public class GreetingManager {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("greetings-bean.xml");
        Greetings greetings = context.getBean(Greetings.class);
        greetings.greet("Krish");

    }
}
