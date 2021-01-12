package org.ksahli.bank.account;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestAmount {

    @Test
    public void should_sum_up_amounts() {
        final var ten = Amount.of(10);
        final var twenty = Amount.of(20);
        final var sum = ten.add(twenty);
        assertThat(sum).isEqualTo(Amount.of(30));
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
