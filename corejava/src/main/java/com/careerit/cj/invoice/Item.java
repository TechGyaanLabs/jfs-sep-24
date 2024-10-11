package com.careerit.cj.invoice;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Item {
    private String description;
    private int quantity;
    private double rate;
    private double amount;
    @JsonProperty("gst_rate")
    private double gstRate;
    private double cgst;
    private double sgst;
    private double total;
}
