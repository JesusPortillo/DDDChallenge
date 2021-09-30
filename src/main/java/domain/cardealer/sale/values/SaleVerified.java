package domain.cardealer.sale.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class SaleVerified implements ValueObject<Boolean> {

    private final Boolean saleVerified;

    public SaleVerified(Boolean saleVerified) {
        Objects.requireNonNull(saleVerified);
        this.saleVerified = saleVerified;
    }

    @Override
    public Boolean value() {
        return saleVerified;
    }
}
