package domain.cardealer.loan.events;

import co.com.sofka.domain.generic.DomainEvent;
import domain.cardealer.loan.values.LoanDate;

public class LoanCreated extends DomainEvent {

    private final LoanDate loanDate;

    public LoanCreated(LoanDate loanDate) {
        super("domain.cardealer.loan.loancreated");
        this.loanDate = loanDate;
    }

    public LoanDate getLoanDate() {
        return loanDate;
    }
}
