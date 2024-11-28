package com.careerit.cbook.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class ApiResponse<T> {

        private boolean success;
        private T data;
        private final Set<String> errors = new HashSet<>();

        public ApiResponse(){

        }
        public ApiResponse(T data){
            this.data = data;
            success = data != null;
        }

        public ApiResponse<T> addError(String error){
           if(StringUtils.hasText(error)){
               errors.add(error);
           }
           return this;
        }

        public static <T> ApiResponse<T> success(T data){
            return new ApiResponse<>(data);
        }


}
