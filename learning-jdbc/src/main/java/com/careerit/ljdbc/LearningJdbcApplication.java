package com.careerit.ljdbc;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class LearningJdbcApplication {

    public static void main(String[] args) {
            String env = "dev";
            if(args.length != 0){
                env = args[0];
                if(!List.of("qa","prod").contains(env)){
                   env = "dev";
                    System.out.println("Invalid environment, setting to dev");
                }
            }else{
                System.out.println("No environment provided, setting to dev");
            }

        Properties properties = new Properties();
        String fileName = "application-"+env + ".properties";
        try {
            properties.load(LearningJdbcApplication.class.getClassLoader().getResourceAsStream(fileName));
            String message = properties.getProperty("message");
            System.out.println("Message : "+message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
