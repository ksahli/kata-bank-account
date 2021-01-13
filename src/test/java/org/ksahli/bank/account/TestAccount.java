package org.ksahli.bank.account;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TestAccount {

    private Account account;
    private History history;

    @BeforeEach
    public void init() {
        history = Mockito.mock(History.class);
        account = new Account(history);
    }

    @Test
    public void should_deposit_amount() {
        final var date = LocalDate.now();
        final var depositAmount = Amount.of(100);
        account.deposit(depositAmount, date);
        assertThat(account.getBalance()).isEqualTo(Amount.of(100));
    }

    @Test
    public void should_deposit_multiple_amounts() {
        final var date = LocalDate.now();
        final var depositAmounts = Arrays.asList(
                Amount.of(100),
                Amount.of(50),
                Amount.of(100)
        );
        depositAmounts.forEach(amount -> account.deposit(amount, date));
        assertThat(account.getBalance()).isEqualTo(Amount.of(250));
    }

    @Test
    public void should_not_deposit_negative_amount() {
        final var date = LocalDate.now();
        final var negativeDepositAmount = Amount.of(-100);
        assertThatThrownBy(() -> account.deposit(negativeDepositAmount, date))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void should_withdraw_amount() {
        final var date = LocalDate.now();
        final var withdrawAmount = Amount.of(100);
        account.withdraw(withdrawAmount, date);
        assertThat(account.getBalance()).isEqualTo(Amount.of(-100));
    }

    @Test
    public void should_withdraw_multiple_amounts() {
        final var date = LocalDate.now();
        final var withdrawAmounts = Arrays.asList(
                Amount.of(100),
                Amount.of(50),
                Amount.of(100)
        );
        withdrawAmounts.forEach(amount -> account.withdraw(amount, date));
        assertThat(account.getBalance()).isEqualTo(Amount.of(-250));
    }

    @Test
    public void should_not_withdraw_negative_amount() {
        final var date = LocalDate.now();
        final var negativeWithdrawAmount = Amount.of(-100);
        assertThatThrownBy(() -> account.withdraw(negativeWithdrawAmount, date))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void should_record_deposit_transactions() {
        final var date = LocalDate.now();
        final Amount depositAmount = Amount.of(100);
        account.deposit(depositAmount, date);
        Mockito.verify(history).append(new Entry(new Transaction(Amount.of(100), date), Amount.of(100)));
    }

    @Test
    public void should_record_withdraw_transactions() {
        final var date = LocalDate.now();
        final Amount withdraw = Amount.of(100);
        account.withdraw(withdraw, date);
        Mockito.verify(history).append(new Entry(new Transaction(Amount.of(-100), date), Amount.of(-100)));
    }

}
