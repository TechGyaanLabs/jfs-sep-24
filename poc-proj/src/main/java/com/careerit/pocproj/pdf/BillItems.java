package com.careerit.pocproj.pdf;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BillItems {
    private String name;
    private String description;
    private long quantity;
    private double price;
    private double totalAmount;
}
