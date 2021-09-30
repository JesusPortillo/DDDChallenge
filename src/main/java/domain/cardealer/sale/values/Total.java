package domain.cardealer.sale.values;

import co.com.sofka.domain.generic.ValueObject;

public class Total implements ValueObject<Double> {

    private final Double total;

    public Total(Double total) {
        this.total = total;
    }

    @Override
    public Double value() {
        return total;
    }
}
