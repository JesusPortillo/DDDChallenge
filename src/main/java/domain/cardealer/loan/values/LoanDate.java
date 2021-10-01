package domain.cardealer.loan.values;

import co.com.sofka.domain.generic.ValueObject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class LoanDate implements ValueObject<String> {

    private final String loanDate;

    public LoanDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        this.loanDate = dtf.format(LocalDateTime.now());
    }

    @Override
    public String value() {
        return loanDate;
    }
}
