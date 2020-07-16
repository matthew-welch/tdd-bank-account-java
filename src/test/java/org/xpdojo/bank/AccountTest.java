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
    @Disabled
    public void depositAnAmountToIncreaseTheBalance() {
        assertThat(account.getBalance()).isEqualTo(10);
    }
}
