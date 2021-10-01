package domain.cardealer.loan;

import co.com.sofka.domain.generic.EventChange;
import domain.cardealer.loan.entities.Loaner;
import domain.cardealer.loan.events.LoanCreated;
import domain.cardealer.loan.events.LoanerAdded;

public class LoanChange extends EventChange {

    public LoanChange(Loan loan){
        apply((LoanCreated event) ->{
            loan.loanDate = event.getLoanDate();
            loan.timeToPay = event.getTimeToPay();
            loan.loanIsPaid = event.getLoanIsPaid();
            loan.isAprobed = event.getIsAprobed();
            loan.saleVerified = event.getSaleVerified();
        });

        apply((LoanerAdded event)->{
            loan.loaner = new Loaner(event.getLoanerId(), event.getName(), event.getEmail(), event.getAge());
        });
    }
}
