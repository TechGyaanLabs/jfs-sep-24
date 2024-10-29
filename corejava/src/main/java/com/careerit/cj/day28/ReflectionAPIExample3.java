package com.careerit.cj.day28;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflectionAPIExample3 {

    public static void main(String[] args) {

            String name = "java.lang.String";

            try{
                Class<?> cls = Class.forName(name);
                Method[] arr = cls.getDeclaredMethods();
                for(Method method:arr){
                    System.out.println(method.getName());
                }
                System.out.println(cls.getSuperclass());
                Constructor[] constructors = cls.getDeclaredConstructors();
                for(Constructor constructor:constructors){
                    System.out.println(constructor);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
    }
}
