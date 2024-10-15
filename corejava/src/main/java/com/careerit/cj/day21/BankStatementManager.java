package com.careerit.cj.day21;

public class BankStatementManager {

    public static void main(String[] args) {
        ParserService obj = new ParserService();
        StatementData statementData = obj.parse("icici_09_2024.json");
        System.out.println(statementData);
    }
}
