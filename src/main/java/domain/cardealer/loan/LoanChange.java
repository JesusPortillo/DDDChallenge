package domain.cardealer.loan;

import co.com.sofka.domain.generic.EventChange;
import domain.cardealer.loan.events.LoanCreated;

public class LoanChange extends EventChange {

    public LoanChange(Loan loan){
        apply((LoanCreated event) ->{
            loan.loanDate = event.getLoanDate();
        });
    }
}
