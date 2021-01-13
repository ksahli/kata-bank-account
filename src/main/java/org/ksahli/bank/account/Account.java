package org.ksahli.bank.account;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Account {

    private Amount balance = Amount.of(0);
    private History history;

    public Account(History history) {
        this.history = history;
    }

    public void deposit(Amount amount, LocalDate date) {
        check(amount);
        record(amount, date);
    }

    public void withdraw(Amount amount, LocalDate date) {
        check(amount);
        record(amount.negate(), date);
    }

    private void record(Amount amount, LocalDate date) {
        final var transaction = new Transaction(amount, date);
        this.balance = transaction.applyTo(this.balance);
        final var entry = new Entry(transaction, this.balance);
        history.append(entry);
    }

    private void check(Amount amount) {
        if (amount.isNegative()) {
            throw new IllegalArgumentException("invalid amount " + amount);
        }
    }

}
