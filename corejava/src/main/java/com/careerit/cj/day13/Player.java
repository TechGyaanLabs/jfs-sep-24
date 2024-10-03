package com.careerit.cj.day13;

public class Player {
    private String name;
    private String role;
    private String country;
    private double amount;

    public Player(String name,String role,String country,double amount){
        this.name = name;
        this.role = role;
        this.country = country;
        this.amount = amount;
    }

    public void showDetails(){
        System.out.println("Name    :"+name);
        System.out.println("Role    :"+role);
        System.out.println("Country :"+country);
        System.out.println("Amount  :"+amount);
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public String getCountry() {
        return country;
    }

    public double getAmount() {
        return amount;
    }
}
