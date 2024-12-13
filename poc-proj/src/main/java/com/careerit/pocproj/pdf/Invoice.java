package com.careerit.pocproj.pdf;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class Invoice {

    private String invoiceNum;
    private LocalDate fromDate;
    private LocalDate toDate;
    private LocalDate invoiceDate;
    private LocalDate dueDate;
    private List<BillItems> billItems;
    private double amount;
    private double tax;
    private double balance;
    private String customerName;


}
