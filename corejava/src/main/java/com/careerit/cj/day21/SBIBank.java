package com.careerit.cj.day21;

import java.time.LocalDate;

public class SBIBank implements Parser {

    @Override
    public StatementData parse(String fileName) {
        StatementData data = new StatementData();
        data.setDate(LocalDate.of(2024, 10, 1));
        data.setAccountNo("SBI1001");
        data.setTotalCharges(2000);
        data.setBalance(200000);
        return data;
    }
}
