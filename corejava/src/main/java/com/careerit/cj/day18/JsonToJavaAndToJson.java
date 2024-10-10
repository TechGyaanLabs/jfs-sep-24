package com.careerit.cj.day18;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonToJavaAndToJson {

    public static void main(String[] args) throws JsonProcessingException {

            String jsonStr = """
                    {
                        "name": "Krish",
                        "email": "krish@gmail.com",
                        "mobile":"9876543210"
                    }
                    """;
            ObjectMapper objectMapper = new ObjectMapper();
            Contact contact = objectMapper.readValue(jsonStr,Contact.class);
            System.out.println(contact);

            String contactJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(contact);
            System.out.println(contactJson);

    }
}
