package org.ksahli.bank.account;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class TestTransaction {

    @Test
    public void should_apply_deposit_transaction() {
        final var amount = Amount.of(100);
        final var transaction = new Transaction(Amount.of(50), LocalDate.now());
        final var amountAfterTransaction = transaction.applyTo(amount);
        Assertions.assertThat(amountAfterTransaction).isEqualTo(Amount.of(150));
    }

    @Test
    public void should_apply_withdraw_transactions() {
        final var amount = Amount.of(100);
        final var transaction = new Transaction(Amount.of(-50), LocalDate.now());
        final var amountAfterTransaction = transaction.applyTo(amount);
        Assertions.assertThat(amountAfterTransaction).isEqualTo(Amount.of(50));
    }

}
