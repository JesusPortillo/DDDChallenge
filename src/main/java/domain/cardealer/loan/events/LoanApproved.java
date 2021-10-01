package domain.cardealer.loan.events;

import co.com.sofka.domain.generic.DomainEvent;
import domain.cardealer.loan.values.IsAprobed;
import domain.cardealer.loan.values.SaleVerified;

public class LoanApproved extends DomainEvent {

    private final IsAprobed isAprobed;
    private final SaleVerified saleVerified;
    public LoanApproved(IsAprobed isAprobed, SaleVerified saleVerified) {
        super("domain.cardealer.loan.loancreated");
        this.isAprobed = isAprobed;
        this.saleVerified = saleVerified;

    }

    public IsAprobed getIsAprobed() {
        return isAprobed;
    }

    public SaleVerified getSaleVerified() {
        return saleVerified;
    }
}
