package com.careerit.cj.day26.json;

import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;

public class GenericsWithUtilMethods {

    public static void main(String[] args) {

        Product product = JsonUtils.loadData("product.json", Product.class);
        System.out.println(product.getId() + " " + product.getName() + " " + product.getPrice());

        List<Transactions> transactions = JsonUtils
                .loadData("transactions.json", new TypeReference<List<Transactions>>() {});

        transactions.forEach(t->{
            System.out.println(t.getId()+" "+t.getName()+" "+t.getDate()+" "+t.getAmount());
        });

    }
}

