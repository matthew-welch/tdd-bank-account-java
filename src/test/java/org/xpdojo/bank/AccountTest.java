package org.xpdojo.bank;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountTest {

    private Account account;

    @BeforeEach
    public void setup() {
        account = new Account();
    }

    @Test
    public void initialBalanceIsZero() {
        assertThat(account.getBalance()).isEqualTo(0);
    }

    @Test
    public void depositingAnAmountWillIncreaseTheBalance() {
        account.deposit(10);
        assertThat(account.getBalance()).isEqualTo(10);
    }

    @Test
    public void withdrawingAnAmountWillDecreaseTheBalance() {
        account.deposit(10);
        assertThat(account.getBalance()).isEqualTo(10);
        account.withdraw(2);
        assertThat(account.getBalance()).isEqualTo(8);
    }

    @Test
    public void moneyCanBeTransferredBetweenAccounts() {
        Account source = new Account();
        source.deposit(6);
        Account destination = new Account();

        source.transfer(5, destination);
        assertThat(source.getBalance()).isEqualTo(1);
        assertThat(destination.getBalance()).isEqualTo(5);
    }

    @Test
    public void exceptionIsThrownWhenNotEnoughFundsAvailableToTransfer() {
        org.junit.jupiter.api.Assertions.assertThrows(RuntimeException.class, () -> account.transfer(100, new Account()));
    }

    @Test
    public void exceptionIsThrownWhenNotEnoughFundsAvailableToWithdraw() {
        org.junit.jupiter.api.Assertions.assertThrows(RuntimeException.class, () -> account.withdraw(100));
    }

    @Test
    public void balanceCanBePrinted() {
        String balance = account.printBalance();
        assertThat(balance).isEqualTo("Available funds: 0");
    }
}
