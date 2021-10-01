package domain.cardealer.loan.values;

import co.com.sofka.domain.generic.Identity;
import domain.cardealer.sale.values.SaleId;

public class LoanId extends Identity {

    public LoanId(){}

    public LoanId(String id){
        super(id);
    }

    public static LoanId of(String id){
        return new LoanId(id);
    }
}
