package com.careerit.cj.day14;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Product{

    private long id;
    private String name;
    private double price;

}
