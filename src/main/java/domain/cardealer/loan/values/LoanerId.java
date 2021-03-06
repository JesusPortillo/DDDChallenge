package domain.cardealer.loan.values;

import co.com.sofka.domain.generic.Identity;

public class LoanerId extends Identity {
    public LoanerId(){}

    public LoanerId(String id){
        super(id);
    }

    public static LoanerId of(String id){
        return new LoanerId(id);
    }
}
