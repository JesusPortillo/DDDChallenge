package domain.cardealer.loan.values;

import co.com.sofka.domain.generic.Identity;

public class DebtorId extends Identity {

    public DebtorId(){}

    public DebtorId(String id){
        super(id);
    }

    public static DebtorId of(String id){
        return new DebtorId(id);
    }
}
