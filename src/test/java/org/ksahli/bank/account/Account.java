package org.ksahli.bank.account;

import lombok.Data;

@Data
public class Account {

    private Amount balance = Amount.of(0);

    public void deposit(Amount amount) {
        if (amount.isNegative()) {
            throw new IllegalArgumentException("invalid amount " + amount);
        }
        this.balance = balance.add(amount);
    }

    public Amount getBalance() {
        return this.balance;
    }

}
