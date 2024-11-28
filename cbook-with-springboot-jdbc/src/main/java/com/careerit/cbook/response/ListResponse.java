package com.careerit.cbook.response;

import java.util.List;

public class ListResponse<T> extends  ApiResponse<List<T>> {

    public ListResponse(){

    }
    public ListResponse(List<T> data){
        super(data);

    }
}
