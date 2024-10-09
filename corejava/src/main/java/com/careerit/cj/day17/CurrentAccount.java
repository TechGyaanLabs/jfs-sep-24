package com.careerit.cj.day17;

public class CurrentAccount extends Account {
    public final double OVER_DRAFT = 10000;

    public CurrentAccount(String accNumber, String name, double balance) {
        super(accNumber,name,balance);
    }

    @Override
    public void withdraw(double amount){
        if(amount <= (balance+OVER_DRAFT)){
            balance -= amount;
            System.out.println("The "+amount+" has been withdrawn from account "+accNumber+" and balance is "+balance);
        }else{
            System.out.println("Sorry, insufficient funds. Please check balance");
        }
    }


}
