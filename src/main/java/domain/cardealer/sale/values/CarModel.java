package domain.cardealer.sale.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class CarModel implements ValueObject<String> {

    private final String carModel;

    public CarModel(String carModel) {
        Objects.requireNonNull(carModel);
        this.carModel = carModel;
    }

    @Override
    public String value() {
        return carModel;
    }
}
