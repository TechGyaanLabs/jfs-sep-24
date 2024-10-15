package com.careerit.cj.day21;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.json.JsonMapper;

import java.time.LocalDate;

public class CityBank implements Parser {

    @Override
    public StatementData parse(String filePath) {
        JsonMapper mapper = new JsonMapper();
        try {
            JsonNode node = mapper.readTree(CityBank.class.getResourceAsStream("/"+filePath));
            String accountNo = node.get("accountNumber").asText();
            LocalDate date = LocalDate.parse(node.get("statementDate").asText());
            double totalCharges = node.get("totalCharge").asDouble();
            double balance = node.get("balance").asDouble();
            StatementData data = new StatementData();
            data.setAccountNo(accountNo);
            data.setDate(date);
            data.setTotalCharges(totalCharges);
            data.setBalance(balance);
            data.setBankType(BankType.CITY);
            return data;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
