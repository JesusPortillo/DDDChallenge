package domain.cardealer.loan.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class LoanIsPaid implements ValueObject<Boolean> {

    private final Boolean loanIsPaid;

    public LoanIsPaid(Boolean loanIsPaid) {
        Objects.requireNonNull(loanIsPaid);
        this.loanIsPaid = loanIsPaid;
    }

    @Override
    public Boolean value() {
        return loanIsPaid;
    }
}
