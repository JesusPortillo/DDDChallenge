package domain.cardealer.sale.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class CarColor implements ValueObject<String> {

    private final String carColor;

    public CarColor(String carColor) {
        Objects.requireNonNull(carColor);
        this.carColor = carColor;
    }

    @Override
    public String value() {
        return carColor;
    }
}
