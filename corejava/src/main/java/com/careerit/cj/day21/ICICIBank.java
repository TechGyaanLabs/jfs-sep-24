package com.careerit.cj.day21;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.json.JsonMapper;

import java.time.LocalDate;

public class ICICIBank implements Parser {

    @Override
    public StatementData parse(String filePath) {
        JsonMapper mapper = new JsonMapper();
        try {
            JsonNode node = mapper.readTree(ICICIBank.class.getResourceAsStream("/"+filePath));
            String accountNo = node.get("account#").asText();
            LocalDate date = LocalDate.parse(node.get("date").asText());
            double totalCharges = node.get("charges").asDouble();
            double balance = node.get("totalBalance").asDouble();
            StatementData data = new StatementData();
            data.setAccountNo(accountNo);
            data.setDate(date);
            data.setTotalCharges(totalCharges);
            data.setBalance(balance);
            data.setBankType(BankType.ICICI);
            return data;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
