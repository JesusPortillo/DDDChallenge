package domain.cardealer.loan.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class TimeToPay implements ValueObject<String> {

    private final String timeToPay;

    public TimeToPay(String timeToPay) {
        Objects.requireNonNull(timeToPay);
        this.timeToPay = timeToPay;
    }


    @Override
    public String value() {
        return timeToPay;
    }
}
