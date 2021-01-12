package org.ksahli.bank.account;

import lombok.EqualsAndHashCode;
import lombok.Value;

import java.math.BigDecimal;
import java.util.Optional;

import static java.math.BigDecimal.ZERO;

@Value
@EqualsAndHashCode
public class Amount {

    BigDecimal value;

    public Amount(BigDecimal value) {
        this.value = value;
    }

    public Amount add(Amount amount) {
        final var valueToAdd = Optional.ofNullable(amount)
                .map(Amount::getValue)
                .orElse(ZERO);
        final var value = this.value.add(valueToAdd);
        return new Amount(value);
    }

    public boolean isNegative() {
        return this.value.compareTo(ZERO) < 0;
    }

    public static Amount of(double value) {
        return new Amount(new BigDecimal(value));
    }

}
