package com.careerit.iplstats.util;

import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter

public class ApiResponse<T> {

    private boolean success;
    private T data;
    private Set<String> errors=new HashSet<>();

    public ApiResponse(T data){
        this.success = data != null;
        this.data = data;
    }

    public ApiResponse<T> withSuccess(T data){
        this.data = data;
        return this;
    }

    public ApiResponse<T> addErrors(String error){
        this.errors.add(error);
        return this;
    }

    public static <T> ApiResponse<T> success(T data){
        return new ApiResponse<>(data);
    }

    public static <T> ApiResponse<T> failure(Set<String> errors){
        ApiResponse<T> response = new ApiResponse<>(null);
        response.errors = errors;
        return response;
    }

}
