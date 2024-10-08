package com.careerit.cj.day16;

class Account{

        double balance;
        public void withdraw(double amount){
            if(amount <= balance){
                balance -= amount;
            }else{
                System.out.println("Insufficient funds");
            }
        }
        public void deposit(double amount){
            balance += amount;
        }
}
class SavingsAccount extends  Account{
      double minBalance;

      // 5000 => 500 => 4500

    @Override
    public void withdraw(double amount){
        if(amount <= (balance - minBalance)){
            balance -= amount;
        }else{
            System.out.println("Insufficient funds");
        }
    }

}
class CurrentAccount extends  Account{

    double overDraft;
    // balance = 900000 od = 100000 => 10,00,000

    public void withdraw(double amount){
        if(amount <= (balance + overDraft)){
            balance -= amount;
        }else{
            System.out.println("Insufficient funds");
        }
    }
}
public class AccountManager {
}
