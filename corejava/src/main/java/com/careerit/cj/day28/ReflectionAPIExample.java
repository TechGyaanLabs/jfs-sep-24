package com.careerit.cj.day28;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReflectionAPIExample {

    public static void main(String[] args) {

            String name = "Krish";

            String jsonStr = """
                    {
                        "name":"Krish",
                        "email":"krish@gmail.com",
                        "phone":"9876543210",
                        "address":{
                            "city":"Hyderabad",
                            "state":"Telangana",
                            "country":"India"
                        }
                    }
                    """;

        try {
            ObjectMapper obj = new ObjectMapper();
            Contact contact = obj.readValue(jsonStr, Contact.class);
            System.out.println(contact);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }
}
