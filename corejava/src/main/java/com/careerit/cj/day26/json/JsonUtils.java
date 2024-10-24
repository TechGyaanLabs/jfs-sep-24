package com.careerit.cj.day26.json;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class JsonUtils {




    public static <T> T loadData(String jsonFile, Class<T> clazz) {
        ObjectMapper mapper = getObjectMapper();

        try {
            return mapper.readValue(JsonUtils.class.getClassLoader().getResourceAsStream(jsonFile), clazz);
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    public static <T> T loadData(String fileName, TypeReference<T> typeReference) {
        ObjectMapper mapper = getObjectMapper();
        try {
            return mapper.readValue(JsonUtils.class.getClassLoader().getResourceAsStream(fileName), typeReference);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> T convertJson(String jsonStr, T t) {

        ObjectMapper mapper = getObjectMapper();
        try {
            return mapper.readValue(jsonStr, (Class<T>) t.getClass());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static ObjectMapper getObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        return mapper;
    }

}
