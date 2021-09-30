package domain.cardealer.sale.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Category implements ValueObject<String> {

    private final String category;

    public Category(String category) {
        Objects.requireNonNull(category);
        this.category = category;
    }

    @Override
    public String value() {
        return category;
    }
}
