package domain.cardealer.sale.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class CarPrice implements ValueObject<Double> {

    private final Double carPrice;

    public CarPrice(Double carPrice) {
        Objects.requireNonNull(carPrice);
        this.carPrice = carPrice;
    }

    @Override
    public Double value() {
        return carPrice;
    }
}
