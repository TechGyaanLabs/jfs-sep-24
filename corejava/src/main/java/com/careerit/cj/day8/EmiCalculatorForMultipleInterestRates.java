package com.careerit.cj.day8;

public class EmiCalculatorForMultipleInterestRates {

    public static void main(String[] args) {

        double amount = 1000000;
        int[] months = {18,24,30,36,42,48,54,60};
        int lb = 12;
        int ub = 24;
        showEmiDetails(amount,months,lb,ub);

    }

    public static void showEmiDetails(double amount, int[] months, int lr, int hr) {
        System.out.println("Amount, Months, Rate, EMI, Interest, Total_Amount");
        for(int month:months) {
            for (int i = lr; i <= hr; i++) {
                double emi = emi(amount, i, month);
                double totalAmount = emi * month;
                double totalInterest = totalAmount - amount;
                System.out.println(amount + ", " + month + ", " + i + ", " + Math.round(emi) + ", " + Math.round(totalInterest) + ", " + Math.round(totalAmount));
            }
            System.out.println("-----------------------------------------");
        }
    }

    public static double emi(double p, double r, int n) {
        r = r / 12 / 100;
        return p * r * (Math.pow(1 + r, n) / (Math.pow(1 + r, n) - 1));
    }

}
