package com.careerit.cj.invoice;

import lombok.Data;

@Data
public class SellerDetails {
    private String name;
    private String gstin;
    private Address address;
}
