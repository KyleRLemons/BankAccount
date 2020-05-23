package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static class Account{
        double balance = 0;

        public Account(double balance){
            this.balance = balance;
        }

        public double getBalance() {
            return balance;
        }

        public double deposit(double money){
            balance = balance + money;
            return balance;
        }

        public double withdraw(double money){
            balance = balance - money;
            return balance;
        }
        public double compareTo(Account o){
            return this.balance - o.balance;
        }


    }

    static class SavingsAccount extends Account{

        public SavingsAccount(double balance){
            super(balance);
        }



        double interest = 0;

        public double compound(double interest){
            balance = balance + balance*interest;
            return balance;
        }

    }
    static class CheckingAccount extends  Account{
        int nextCheckNumber = 1000;

        public CheckingAccount(double balance){
            super(balance);
        }

        public void orderChecks(){
            nextCheckNumber = nextCheckNumber + 1;
        }

    }
    public static void main(String[] args) {
        ArrayList<Account> list = new ArrayList<>();
        list.add(new Account(100.00));
        list.add(new SavingsAccount(150.00));
        list.add(new CheckingAccount(120.00));
        list.get(0).deposit(100);
        list.get(0).withdraw(50);
        System.out.println("Account balance is: " + list.get(0).getBalance());
        ((SavingsAccount)list.get(2)).compound(1.5);
        ((CheckingAccount)list.get(2)).orderChecks();

        //Couldn't figure out how to get the collections.sort to work so just had to give up on it due to timing



    }
}
