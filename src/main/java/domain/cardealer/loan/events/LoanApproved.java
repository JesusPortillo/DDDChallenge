package domain.cardealer.loan.events;

import co.com.sofka.domain.generic.DomainEvent;
import domain.cardealer.loan.values.IsAprobed;

public class LoanApproved extends DomainEvent {

    private final IsAprobed isAprobed;

    public LoanApproved(IsAprobed isAprobed) {
        super("domain.cardealer.loan.loancreated");
        this.isAprobed = isAprobed;
    }

    public IsAprobed getIsAprobed() {
        return isAprobed;
    }

}
