package domain.cardealer.generics;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Age implements ValueObject<String> {

    private final String age;

    public Age(String age) {
        Objects.requireNonNull(age);
        this.age = age;
    }

    @Override
    public String value() {
        return age;
    }
}
