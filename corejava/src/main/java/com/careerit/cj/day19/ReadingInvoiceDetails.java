package com.careerit.cj.day19;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class ReadingInvoiceDetails {

    public static void main(String[] args) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(ReadingInvoiceDetails.class.getResource("/invoice.json"));
        JsonNode buyerDetails = jsonNode.get("buyer_details");
        String name = buyerDetails.get("name").toString();
        String country = buyerDetails.get("address").get("country").toString();
        System.out.println(name+" "+country);

    }
}
