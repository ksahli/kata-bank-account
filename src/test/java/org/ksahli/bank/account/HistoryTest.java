package org.ksahli.bank.account;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;

import static java.time.Month.FEBRUARY;
import static java.time.Month.JANUARY;

public class HistoryTest {

    @Test
    public void should_print_history() {
        final var history = new History();

        final var entries = Arrays.asList(
                Entry.builder()
                        .transaction(
                            Transaction.builder()
                                .amount(Amount.of(100))
                                .date(LocalDate.of(2021, JANUARY, 13))
                                .build()
                        )
                        .balance(Amount.of(100)).build(),
                Entry.builder()
                        .transaction(
                            Transaction.builder()
                                    .amount(Amount.of(-50))
                                    .date(LocalDate.of(2021, FEBRUARY, 14))
                                    .build()
                        )
                        .balance(Amount.of(50)).build(),
                Entry.builder()
                        .transaction(
                            Transaction.builder()
                                    .amount(Amount.of(1200))
                                    .date(LocalDate.of(2021, Month.MARCH, 15))
                                    .build()
                        )
                        .balance(Amount.of(1250)).build()
        );

        entries.forEach(history::append);

        final var expectedLines =
                "2021-01-13 | 100.00 | 100.00" + "\n" +
                "2021-02-14 | -50.00 | 50.00" + "\n" +
                "2021-03-15 | 1200.00 | 1250.00" + "\n";

        final var actualLines = new StringBuilder();
        history.print(line -> actualLines.append(line).append("\n"));

        Assertions.assertThat(actualLines.toString()).isEqualTo(expectedLines);
    }

}
