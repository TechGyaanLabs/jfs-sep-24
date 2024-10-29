package com.careerit.cj.day28;

import org.apache.commons.lang3.reflect.FieldUtils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class ReflectionExample2 {

    public static void main(String[] args) {

        Map<String, Object> map = new HashMap<>();
        map.put("name", "Krish");
        map.put("email", "krish@gmail.com");
        map.put("phone", "9876543210");

        Map<String, Object> addressMap = new HashMap<>();
        addressMap.put("city", "Hyderabad");
        addressMap.put("state", "Telangana");
        addressMap.put("country", "India");
        map.put("address", addressMap);

        Contact contact = convertMapToBean(map, Contact.class);
        System.out.println(contact);

        Map<String, Object> productMap = new HashMap<>();
        productMap.put("pid", 1001);
        productMap.put("productName", "Laptop");
        productMap.put("price", 45000.0);
        productMap.put("description", "Lenovo Laptop with 8GB RAM and 512GB SSD");
        Product product = convertMapToBean(productMap, Product.class);
        System.out.println(product);

    }

    public static <T> T convertMapToBean(Map<String, Object> map, Class<T> clazz) {
        try {
            T obj = clazz.getConstructor().newInstance();
            for(Field field:clazz.getDeclaredFields()){

                FieldUtils.writeField(obj, field.getName(), map.get(field.getName()), true);
            }
            return obj;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
