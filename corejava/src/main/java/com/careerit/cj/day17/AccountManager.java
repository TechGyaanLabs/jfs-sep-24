package com.careerit.cj.day17;

import java.util.List;

public class AccountManager {

    public static void main(String[] args) {

            Account acc1 = new SavingsAccount("SB202401090000231","Krish",5000);
            Account acc2 = new SavingsAccount("SB202401090000231","Krish",5000);
            Account acc3 = new CurrentAccount("CB202401090000231","TMZ",345000);
            Account acc4 = new CurrentAccount("CB202401090000231","KTVM",25000);
            Account acc5 = new SavingsAccount("SB202401090000231","Krish",5000);

            List<Account> accList = List.of(acc1,acc2,acc3,acc4,acc5);
            for(Account acc:accList){
                if(acc instanceof CurrentAccount cacc){
                    System.out.println("Current account "+cacc.OVER_DRAFT);
                }else if(acc instanceof SavingsAccount sacc){
                    System.out.println("Saving account "+sacc.MIN_AMOUNT);
                }
            }

    }
}
