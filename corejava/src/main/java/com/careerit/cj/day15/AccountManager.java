package com.careerit.cj.day15;

class Account{
        private String accountNumber;
        private String name;
        private String ssn;
        private String mobile;
        private double balance;


    public Account(String accountNumber, String name, String ssn, String mobile,double balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.ssn = ssn;
        this.mobile = mobile;
        this.balance = balance;
    }
    public void showDetails(){
        System.out.println("Acc number :"+AppUtil.maskStr(accountNumber));
        System.out.println("Name       :"+name);
        System.out.println("Mobile     :"+AppUtil.maskStr(mobile));
        System.out.println("SSN        :"+AppUtil.maskStr(ssn));
        System.out.println("Balance    :"+balance);
    }
}
public class AccountManager {

    public static void main(String[] args) {

        Account acc1 = new Account("SB10012024123","Krish","9876543210","2345678901",500000);
        acc1.showDetails();
    }
}
