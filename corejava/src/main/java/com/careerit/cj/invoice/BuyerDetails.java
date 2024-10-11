package com.careerit.cj.invoice;

import lombok.Data;

@Data
public class BuyerDetails {
    private String name;
    private String gstin;
    private Address address;
}
