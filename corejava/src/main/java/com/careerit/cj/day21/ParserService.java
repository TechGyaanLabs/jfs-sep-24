package com.careerit.cj.day21;

public class ParserService {


    public StatementData parse(String fileName){
        String bankName = fileName.contains("_") ? fileName.substring(0, fileName.indexOf("_")) : "city";
        BankType bankType = BankType.valueOf(bankName.toUpperCase());
        Parser parser = getParser(bankType);
        return parser.parse(fileName);
    }


    public Parser getParser(BankType bankName) {
        return switch (bankName) {
            case YES -> new YesBank();
            case CITY -> new CityBank();
            case ICICI -> new ICICIBank();
            case SBI -> new SBIBank();
        };
    }

}
