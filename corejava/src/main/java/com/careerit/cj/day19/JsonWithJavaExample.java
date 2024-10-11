package com.careerit.cj.day19;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jayway.jsonpath.JsonPath;

public class JsonWithJavaExample {


    public static void main(String[] args) throws JsonProcessingException {

        String jsonStr = """
                    {
                        "customer": "MTR",
                        "type": "small",
                        "address": [
                        {
                            "city": "Bangalore",
                            "state": "KA",
                            "country": "India",
                            "pinCode": "560070",
                            "countryDetails":
                                {
                                   "code":{
                                            "ccode": "91",
                                            "currecy": "INR"
                                    }   
                                }
                        },
                        {
                            "city": "Mumbai",
                            "state": "MH",
                            "country": "India",
                            "pinCode": "670070",
                            "countryDetails":
                                {
                                   "code":{
                                            "ccode": "91",
                                            "currecy": "USD"
                                    }   
                                }
                        }
                        ]
                    }
                """;

        String str = JsonPath.read(jsonStr,"$.address[1].countryDetails.code.currecy");
        System.out.println(str);
    }
}
