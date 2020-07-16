package org.xpdojo.bank;

public class Account {

    private int balance;

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        balance += amount;
    }

    public void withdraw(int amount) {
        checkAvailableFunds(amount);
        balance -= amount;
    }

    public void transfer(int amount, Account destination) {
        checkAvailableFunds(amount);
        destination.deposit(amount);
        balance -= amount;
    }

    private void checkAvailableFunds(int amount) {
        if (balance < amount) {
            throw new RuntimeException("not enough money");
        }
    }

    public String printBalance() {
        return "Available funds: " + balance;
    }
}
