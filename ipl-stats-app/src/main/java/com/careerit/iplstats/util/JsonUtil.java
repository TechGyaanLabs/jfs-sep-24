package com.careerit.iplstats.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;

public final class JsonUtil {

    private JsonUtil() {
    }
    public static <T> T getObjectFromFile(String fileName, TypeReference<T> typeReference) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            if(StringUtils.isBlank(fileName)){
                throw new IllegalArgumentException("File name should not be empty or null");
            }
            return mapper.readValue(JsonUtil.class.getClassLoader().getResourceAsStream(fileName), typeReference);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

}

