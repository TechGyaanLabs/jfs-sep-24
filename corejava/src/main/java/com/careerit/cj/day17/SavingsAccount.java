package com.careerit.cj.day17;

public class SavingsAccount extends  Account {

    public final double MIN_AMOUNT = 500;

    public SavingsAccount(String accNumber, String name, double balance) {
        super(accNumber,name,balance);
    }
    @Override
    public void withdraw(double amount){
        if(amount <= (balance-MIN_AMOUNT)){
            balance -= amount;
            System.out.println("The "+amount+" has been withdrawn from account "+accNumber+" and balance is "+balance);
        }else{
            System.out.println("Sorry, insufficient funds. Please check balance");
        }
    }


}
