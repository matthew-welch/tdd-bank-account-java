package org.xpdojo.bank;

public class Account {

    private int balance;

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        balance += amount;
    }
}
