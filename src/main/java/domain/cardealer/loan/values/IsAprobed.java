package domain.cardealer.loan.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class IsAprobed implements ValueObject<Boolean> {

    private final Boolean isAprobed;

    public IsAprobed(Boolean isAprobed) {
        Objects.requireNonNull(isAprobed);
        this.isAprobed = isAprobed;
    }

    @Override
    public Boolean value() {
        return isAprobed;
    }
}
