package com.careerit.cj.day21;

import lombok.Data;

import java.time.LocalDate;

@Data
public class StatementData {
        private String accountNo;
        private LocalDate date;
        private double totalCharges;
        private double balance;
        private BankType bankType;
}
