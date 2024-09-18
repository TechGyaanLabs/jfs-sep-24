package com.careerit.cj.day1;

public class SumAndAvgOfThreePersonWeights {

  public static void main(String[] args) {

    float weight1 = 25.50f;
    float weight2 = 35.50f;
    float weight3 = 55.30f;

    float sumOfWeight = (weight1 + weight2 + weight3);
    float avgWeight = sumOfWeight / 3;

    System.out.println("Sum of weights :" + sumOfWeight);
    System.out.println("Avg weight     :" + avgWeight);


  }
}
