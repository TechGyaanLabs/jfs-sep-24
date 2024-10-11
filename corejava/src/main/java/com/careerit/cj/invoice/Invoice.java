package com.careerit.cj.invoice;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.List;

@Data
public class Invoice {
    @JsonProperty("invoice_number")
    private String invoiceNumber;
    @JsonProperty("invoice_date")
    private String invoiceDate;
    @JsonProperty("seller_details")
    private SellerDetails sellerDetails;
    @JsonProperty("buyer_details")
    private BuyerDetails buyerDetails;
    private List<Item> items;
    @JsonProperty("total_before_tax")
    private double totalBeforeTax;
    @JsonProperty("cgst_total")
    private double cgstTotal;
    @JsonProperty("sgst_total")
    private double sgstTotal;
    @JsonProperty("total_tax")
    private double totalTax;
    @JsonProperty("grand_total")
    private double grandTotal;
    @JsonProperty("payment_terms")
    private String paymentTerms;
}
