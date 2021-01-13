package org.ksahli.bank.account;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static java.time.Month.*;
import static org.assertj.core.util.Lists.list;

public class HistoryTest {

    @Test
    public void should_print_history() {
        final var history = new History();
        list(
                new Entry(new Transaction(Amount.of(100), LocalDate.of(2021, JANUARY, 13)), Amount.of(100)),
                new Entry(new Transaction(Amount.of(-50), LocalDate.of(2021, FEBRUARY, 14)), Amount.of(50)),
                new Entry(new Transaction(Amount.of(1200), LocalDate.of(2021, MARCH, 15)), Amount.of(1250))
        ).forEach(history::append);

        final var expectedLines = "date | amount | balance" + "\n"+
                "2021-01-13 | 100.00 | 100.00" + "\n" +
                "2021-02-14 | -50.00 | 50.00" + "\n" +
                "2021-03-15 | 1200.00 | 1250.00" + "\n";

        final var actualLines = new StringBuilder();
        history.print(line -> actualLines.append(line).append("\n"));

        Assertions.assertThat(actualLines.toString()).isEqualTo(expectedLines);
    }

}
