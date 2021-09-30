package domain.cardealer.sale.values;

import co.com.sofka.domain.generic.ValueObject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class SaleDate implements ValueObject<String> {

    private final String saleDate;

    public SaleDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        this.saleDate = dtf.format(LocalDateTime.now());
    }

    @Override
    public String value() {
        return saleDate;
    }
}
