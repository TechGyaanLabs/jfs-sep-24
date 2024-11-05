package com.careerit.ljdbc;

import org.yaml.snakeyaml.Yaml;

import java.util.Map;

public class SnakeYamlExample {
    public static void main(String[] args) {

        String yamlStr = """
"name": "John"
"age": 30
"city": "New York"
"skills":
    - Java
    - Python
    - Spring
"address":
    "street": "123 Main St"
    "city": "New York"
    "zip": 10001
                """;

        //Yaml yaml = new Yaml();
        //Employee employee = yaml.loadAs(yamlStr, Employee.class);
        // System.out.println(employee);


        Yaml yaml = new Yaml();

        Map<String,Object> map =  yaml.load(SnakeYamlExample.class.getClassLoader().getResourceAsStream("invoice.yaml"));

        System.out.println(map);

        Object invoice = map.get("invoice");
        System.out.println(((Map<String,Object>)invoice).get("id"));

        
    }


}
