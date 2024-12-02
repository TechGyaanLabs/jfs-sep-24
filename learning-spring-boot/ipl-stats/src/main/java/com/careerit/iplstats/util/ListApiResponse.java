package com.careerit.iplstats.util;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class ListApiResponse<T> extends ApiResponse<T> {

    private long count;

    public ListApiResponse(boolean success, List<T> data, long count) {
        super(data);
        this.count = count;
    }

    public static <T> ListApiResponse<T> success(List<T> data, long count) {
        return new ListApiResponse<>(true, data, count);
    }

    public static <T> ListApiResponse<T> failure(List<T> data, long count) {
        return new ListApiResponse<>(false, data, count);
    }

}
