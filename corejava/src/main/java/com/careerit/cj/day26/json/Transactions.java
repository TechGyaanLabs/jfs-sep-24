package com.careerit.cj.day26.json;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Transactions {

    private long id;
    private String name;
    private LocalDate date;
    private double amount;
}
