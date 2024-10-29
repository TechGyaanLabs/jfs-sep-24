package com.careerit.cj.refassignment;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class GreetingManager {

    private static Properties properties = new Properties();
    static{
        try {
            properties.load(GreetingManager.class.getResourceAsStream("/greetings.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        GreetingService greetingService = getGreetingService();
        System.out.println(greetingService.greet("Krish"));
    }

    private static GreetingService getGreetingService() {
        try {
            String className = properties.getProperty("cls_name");
            Class<?> cls = Class.forName(className);
            return (GreetingService)cls.getConstructor().newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
