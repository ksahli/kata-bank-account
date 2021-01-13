package org.ksahli.bank.account;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class EntryTest {

    @Test
    public void should_print_deposit_entry() {
        final var date = LocalDate.of(2021, 1, 13);
        final var entry = new Entry(new Transaction(Amount.of(100), date), Amount.of(200));
        entry.print((line) -> Assertions.assertThat(line).isEqualTo("2021-01-13 | 100.00 | 200.00"));
    }

    @Test
    public void should_print_withdraw_entry() {
        final var date = LocalDate.of(2021, 1, 13);
        final var entry = new Entry(new Transaction(Amount.of(-100), date), Amount.of(200));
        entry.print((line) -> Assertions.assertThat(line).isEqualTo("2021-01-13 | -100.00 | 200.00"));
    }


}
