package domain.cardealer.sale.values;

import co.com.sofka.domain.generic.Identity;

public class SalesmanId extends Identity {

    public SalesmanId(){}

    public SalesmanId(String id){
        super(id);
    }

    public static SalesmanId of(String id){
        return new SalesmanId(id);
    }
}
