package com.careerit.cj.day28;

import java.lang.reflect.Method;

public class ReflectionExample1 {

    public static void main(String[] args) {

            try{
                Class<?> clazz = Class.forName(Contact.class.getName());
                Method[] methods = clazz.getDeclaredMethods();

                for(Method method:methods){
                    System.out.println(method.getName() + " : "+method.getReturnType());
                    System.out.println("Parameters : ");
                    Class<?>[] params = method.getParameterTypes();
                    for(Class<?> param:params){
                        System.out.println(param.getName());
                    }
                    System.out.println("-------------------------------------------------");
                }

            }catch (ClassNotFoundException e){
                e.printStackTrace();
            }
    }


}
