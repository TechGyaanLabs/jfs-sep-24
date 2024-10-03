package com.careerit.cj.day13;

class Account {
    public static String bankName = "SBI";
    private String accNumber;
    private String name;
    private double balance;

    public Account(String accNumber, String name, double balance) {
        this.accNumber = accNumber;
        this.name = name;
        this.balance = balance;
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("After withdraw amount " + amount + " the balance is : " + balance);
        } else {
            System.out.println("Sorry! you don't have sufficient funds ");
        }
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("After deposit of amount " + amount + " the balance is : " + balance);
    }

    public void showDetails() {
        System.out.println("Bank name      : " + bankName);
        System.out.println("Account number : " + accNumber);
        System.out.println("Name           : " + name);
        System.out.println("Balance        : " + balance);
    }


}

public class AccountManager {

    public static void main(String[] args) {
        Account account1 = new Account("SB001", "Krish", 3500);
        Account account2 = new Account("SB002", "Mohan", 4500);

        account1.showDetails();
        System.out.println("-".repeat(100));
        account2.showDetails();
        System.out.println("-".repeat(100));
        account1.withdraw(500);
        account2.deposit(5500);
        System.out.println("-".repeat(100));
        account1.showDetails();
        System.out.println("-".repeat(100));
        account2.showDetails();
    }
}
