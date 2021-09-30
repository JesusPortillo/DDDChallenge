package domain.cardealer.generics;

import co.com.sofka.domain.generic.ValueObject;

public class Email implements ValueObject<String> {

    private final String email;

    public Email(String email) {
        this.email = email;
    }

    @Override
    public String value() {
        return email;
    }
}
