package domain.cardealer.loan.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class AmountToPayPerMonth implements ValueObject<Double> {

    private final Double amountToPayPerMonth;

    public AmountToPayPerMonth(Double amountToPayPerMonth) {
        Objects.requireNonNull(amountToPayPerMonth);
        this.amountToPayPerMonth = amountToPayPerMonth;
    }

    @Override
    public Double value() {
        return amountToPayPerMonth;
    }
}
