package org.ksahli.bank.account;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TestAccount {

    @Test
    public void should_deposit_amount() {
        final var account = new Account();
        final var depositAmount = Amount.of(100);
        account.deposit(depositAmount);
        assertThat(account.getBalance()).isEqualTo(Amount.of(100));
    }

    @Test
    public void should_deposit_multiple_amounts() {
        final var account = new Account();
        final var depositAmounts = Arrays.asList(
                Amount.of(100),
                Amount.of(50),
                Amount.of(100)
        );
        depositAmounts.forEach(account::deposit);
        assertThat(account.getBalance()).isEqualTo(Amount.of(250));
    }

    @Test
    public void should_not_deposit_negative_amount() {
        final var account = new Account();
        final var negativeDepositAmount = Amount.of(-100);
        assertThatThrownBy(() -> account.deposit(negativeDepositAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void should_withdraw_amount() {
        final var account = new Account();
        final var withdrawAmount = Amount.of(100);
        account.withdraw(withdrawAmount);
        assertThat(account.getBalance()).isEqualTo(Amount.of(-100));
    }

    @Test
    public void should_withdraw_multiple_amounts() {
        final var account = new Account();
        final var withdrawAmounts = Arrays.asList(
                Amount.of(100),
                Amount.of(50),
                Amount.of(100)
        );
        withdrawAmounts.forEach(account::withdraw);
        assertThat(account.getBalance()).isEqualTo(Amount.of(-250));
    }

    @Test
    public void should_not_withdraw_negative_amount() {
        final var account = new Account();
        final var negativeWithdrawAmount = Amount.of(-100);
        assertThatThrownBy(() -> account.withdraw(negativeWithdrawAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
