package com.careerit.pocproj.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.util.List;
import java.util.Map;


public class ConvertUtil {



    public static void main(String[] args) {


            Employee emp =
                    Employee.
                            builder()
                            .empno(1001)
                            .ename("Krish")
                            .salary(45000)
                            .build();


            List<Map<String,Object>> list =
                    List.of(Map.of("empno",1002,"ename","Charan","salary",55000),
                            Map.of("empno",1003,"ename","Manoj","salary",65000)
                            );
            System.out.println(list);
            ObjectMapper objectMapper = new ObjectMapper();
            XmlMapper xmlMapper = new XmlMapper();
        try {
            String jsonStr = objectMapper.writeValueAsString(emp);
            System.out.println(jsonStr);
            String xmlString = xmlMapper.writeValueAsString(emp);
            System.out.println(xmlString);

            // convert map to object

            for(Map<String,Object> map:list) {
                String empString = objectMapper.writeValueAsString(map);
                Employee emp1 = objectMapper.readValue(empString, Employee.class);
                System.out.println(emp1);
            }


        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }
}
