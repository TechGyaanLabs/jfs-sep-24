package com.careerit.cj.day21;

import java.time.LocalDate;

public class YesBank implements Parser {

    @Override
    public StatementData parse(String fileName) {
        StatementData data = new StatementData();
        data.setDate(LocalDate.of(2024, 10, 1));
        data.setAccountNo("YES1001");
        data.setTotalCharges(3000);
        data.setBalance(300000);
        return data;
    }
}
