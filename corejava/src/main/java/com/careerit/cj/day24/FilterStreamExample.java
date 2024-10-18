package com.careerit.cj.day24;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
class Stock{
    @JsonProperty("CompanyName")
    private String companyName;
    @JsonProperty("Price")
    private double price;
    @JsonProperty("Location")
    private String location;
    @JsonProperty("Ticker")
    private String ticker;
}

@Getter
@Setter
@ToString
class StockWithPrice{
    private String ticker;
    private double price;
}


public class FilterStreamExample {

    public static void main(String[] args) {

        List<Stock> list = JsonUtil.fromJson("top_20_stocks.json", new TypeReference<List<Stock>>() {});

        // All tickers of the stocks which are in location Bangalore


        List<StockWithPrice> stocks = new ArrayList<>();

        for(Stock stock:list) {
            if(stock.getLocation().equals("Bengaluru")){
                StockWithPrice obj = new StockWithPrice();
                obj.setTicker(stock.getTicker());
                obj.setPrice(stock.getPrice());
                stocks.add(obj);
            }
        }
        System.out.println(stocks);

        List<StockWithPrice> stocks1 = list.stream()
                .filter(e -> e.getLocation().equals("Bengaluru"))
                .map(e -> {
                    StockWithPrice obj = new StockWithPrice();
                    obj.setTicker(e.getTicker());
                    obj.setPrice(e.getPrice());
                    return obj;
                })
                .toList();

    }

}
