package com.careerit.iplstats.util;

import lombok.*;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ApiResponse<T> {

    private boolean success;
    private T data;
    private Set<String> errors;

    public ApiResponse(T data){
        this.data = data;
    }

    public ApiResponse(List<T> data){
        this.data = (T) data;
    }

    public static <T> ApiResponse<T> success(T data){
        return ApiResponse.<T>builder().success(true).data(data).build();
    }

    public static <T> ApiResponse<T> failure(Set<String> errors){
        return ApiResponse.<T>builder().success(false).errors(errors).build();
    }

}
