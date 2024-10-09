package com.careerit.cj.day17;

public abstract class Account {

    protected String accNumber;
    protected String name;
    protected double balance;

    public Account(String accNumber, String name, double balance) {
        this.accNumber = accNumber;
        this.name = name;
        this.balance = balance;
    }
    public abstract void withdraw(double amount);

    public void deposit(double amount) {
        balance += amount;
        System.out.println("The " + amount + " has been deposited to account " + accNumber + " and balance is " + balance);
    }

    public void showBasicDetails() {
        System.out.println("Acc Number :" + accNumber);
        System.out.println("Name       :" + name);
        System.out.println("Balance    :" + balance);
    }

}
