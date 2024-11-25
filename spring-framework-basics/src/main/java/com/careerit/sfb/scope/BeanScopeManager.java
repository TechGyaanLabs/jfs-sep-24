package com.careerit.sfb.scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan(basePackages = "com.careerit.sfb.scope")
public class BeanScopeManager {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(BeanScopeManager.class);
        DbConnection dbConnection1 = context.getBean(DbConnection.class);
        DbConnection dbConnection2 = context.getBean(DbConnection.class);
        DbConnection dbConnection3 = context.getBean(DbConnection.class);

        System.out.println(dbConnection1);
        System.out.println(dbConnection2);
        System.out.println(dbConnection3);


    }
}
