package org.ksahli.bank.account;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AmountTest {

    @Test
    public void should_sum_up_amounts() {
        final var ten = Amount.of(10);
        final var twenty = Amount.of(20);
        final var sum = ten.add(twenty);
        assertThat(sum).isEqualTo(Amount.of(30));
    }

    @Test
    public void should_subtract_amounts() {
        final var thirty = Amount.of(30);
        final var ten = Amount.of(10);
        final var difference = thirty.subtract(ten);
        assertThat(difference).isEqualTo(Amount.of(20));
    }

    @Test
    public void should_return_negative_value() {
        final var amount = Amount.of(100);
        final var negativeAmount = amount.negate();
        assertThat(negativeAmount).isEqualTo(Amount.of(-100));
    }

    @Test
    public void should_return_positive_value() {
        final var amount = Amount.of(-100);
        final var positiveAmount = amount.negate();
        assertThat(positiveAmount).isEqualTo(Amount.of(100));
    }

    @Test
    public void should_be_negative() {
        final var negativeAmount = Amount.of(-100);
        assertThat(negativeAmount.isNegative()).isTrue();
    }

    @Test
    public void should_be_positive() {
        final var positiveAmount = Amount.of(100);
        assertThat(positiveAmount.isNegative()).isFalse();
    }

}
