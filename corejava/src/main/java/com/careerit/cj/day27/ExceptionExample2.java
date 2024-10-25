package com.careerit.cj.day27;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExceptionExample2 {

    public static void main(String[] args)  {
        System.out.println("Start of main method");
        String data = "Rajesh,Charan,Kiran,CV,Jayesh,Ramesh";

        // Get each name and prepare short name, full name and length of the name store this data into json file
        // name: shortName:  lengthOfName:
        // Short name should have 3 characters from the name

        List<Map<String, Object>> list = convertDataToListOfMap(data);
        writeDataToJsonFile(list);
        System.out.println("End of main method");

    }

    private static void writeDataToJsonFile(List<Map<String, Object>> list) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("names.json"), list);
            System.out.println("Data is stored into names.json file");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private static List<Map<String, Object>> convertDataToListOfMap(String data) {
        List<Map<String, Object>> list = new ArrayList<>();
        String[] names = data.split(",");

        for (String name : names) {
            String shortName = name;
            if(name.length()>3){
                shortName = name.substring(0,3);
            }
            shortName = shortName.toUpperCase();
            int length = name.length();
            Map<String,Object> map = Map.of("name",name,"shortName",shortName,"lengthOfName",length);
            list.add(map);
        }
        return list;
    }
}
