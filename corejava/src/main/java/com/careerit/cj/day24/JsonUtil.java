package com.careerit.cj.day24;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public final class JsonUtil {


        public static <T> T  fromJson(String fileName, Class<T> clazz){
            try{
                if(fileName != null && !fileName.startsWith("/")){
                    fileName = "/" + fileName;
                }
                ObjectMapper mapper = new ObjectMapper();
                return mapper.readValue(JsonUtil.class.getResource(fileName), clazz);
            }catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }

        public static  <T> T fromJson(String fileName, TypeReference<T> typeReference){
            try{
                if(fileName != null && !fileName.startsWith("/")){
                    fileName = "/" + fileName;
                }
                ObjectMapper mapper = new ObjectMapper();
                return mapper.readValue(JsonUtil.class.getResource(fileName), typeReference);
            }catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }

        public static ObjectMapper getMapper(){
            ObjectMapper mapper = new ObjectMapper();
            return mapper;
        }
}
