package domain.cardealer.sale.values;

import co.com.sofka.domain.generic.Identity;
import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class SaleId extends Identity {

    public SaleId(){}

    public SaleId(String id){
        super(id);
    }

    public static SaleId of(String id){
        return new SaleId(id);
    }
}
