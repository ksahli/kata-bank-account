package org.ksahli.bank.account;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDate;

@Value
@Builder
public class Transaction {

    Amount amount;
    LocalDate date;

    public Amount applyTo(Amount amount) {
        return amount.add(this.amount);
    }

}
