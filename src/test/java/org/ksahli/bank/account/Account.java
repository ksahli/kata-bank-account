package org.ksahli.bank.account;

import lombok.Data;

@Data
public class Account {

    private Amount balance = Amount.of(0);

    public void deposit(Amount amount) {
        checkAmount(amount);
        this.balance = balance.add(amount);
    }

    public void withdraw(Amount withdrawAmount) {
        checkAmount(withdrawAmount);
        this.balance = balance.subtract(withdrawAmount);
    }

    private void checkAmount(Amount amount) {
        if (amount.isNegative()) {
            throw new IllegalArgumentException("invalid amount " + amount);
        }
    }

}
