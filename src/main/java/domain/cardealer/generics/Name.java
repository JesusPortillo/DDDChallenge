package domain.cardealer.generics;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Name implements ValueObject<String> {

    private final String name;

    public Name(String name) {
        Objects.requireNonNull(name);
        this.name = name;
    }

    @Override
    public String value() {
        return name;
    }
}
