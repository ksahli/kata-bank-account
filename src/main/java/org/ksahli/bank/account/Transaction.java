package org.ksahli.bank.account;

import lombok.Value;

import java.time.LocalDate;

@Value
public class Transaction {

    Amount amount;
    LocalDate date;

    public Amount applyTo(Amount amount) {
        return amount.add(this.amount);
    }

}
