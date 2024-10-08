package com.careerit.cj.day16;

public class FinalVariablesExample {
    private final String VERSION = "V1";
    public static final String S3_BUCKET_NAME="invoices";

    public static void main(final String[] args) {

            FinalVariablesExample obj = new FinalVariablesExample();
            //args = new String[]{"Hello"};
            args[0] = "Hello";
            final int DAYS_IN_WEEK = 7;
    }



}
