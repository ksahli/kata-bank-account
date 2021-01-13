package org.ksahli.bank.account;

import lombok.Builder;
import lombok.Value;

import javax.swing.*;
import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.util.function.Consumer;

@Value
@Builder
public class Entry {

    public static final String  FORMAT = "%s | %.2f | %.2f";
    public static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    Transaction transaction;
    Amount balance;

    public void print(Consumer<String> printer) {
        final var date = dateTimeFormatter.format(this.transaction.getDate());
        final var amount = this.transaction.getAmount().getValue();
        final var balance = this.balance.getValue();
        final var line = String.format(FORMAT, date, amount, balance);
        printer.accept(line);
    }

}
