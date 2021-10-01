package domain.cardealer.loan.events;

import co.com.sofka.domain.generic.DomainEvent;
import domain.cardealer.loan.values.LoanId;
import domain.cardealer.loan.values.TimeToPay;

public class TimeToPayExtended extends DomainEvent {

    private final LoanId loanId;
    private final TimeToPay timeToPay;

    public TimeToPayExtended(LoanId loanId, TimeToPay timeToPay) {
        super("domain.cardealer.loan.loanerupdated");
        this.loanId = loanId;
        this.timeToPay = timeToPay;
    }

    public LoanId getLoanId() {
        return loanId;
    }

    public TimeToPay getTimeToPay() {
        return timeToPay;
    }
}
