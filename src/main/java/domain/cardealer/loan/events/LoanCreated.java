package domain.cardealer.loan.events;

import co.com.sofka.domain.generic.DomainEvent;
import domain.cardealer.loan.values.*;

public class LoanCreated extends DomainEvent {

    private final LoanDate loanDate;
    private final TimeToPay timeToPay;
    private final LoanIsPaid loanIsPaid;
    private final IsAprobed isAprobed;
    private final SaleVerified saleVerified;
    private final AmountToPayPerMonth amountToPayPerMonth;


    public LoanCreated(LoanDate loanDate, TimeToPay timeToPay, LoanIsPaid loanIsPaid,
                       IsAprobed isAprobed, SaleVerified saleVerified, AmountToPayPerMonth amountToPayPerMonth) {
        super("domain.cardealer.loan.loancreated");
        this.loanDate = loanDate;
        this.timeToPay = timeToPay;
        this.loanIsPaid = loanIsPaid;
        this.isAprobed = isAprobed;
        this.saleVerified = saleVerified;
        this.amountToPayPerMonth = amountToPayPerMonth;
    }

    public LoanDate getLoanDate() {
        return loanDate;
    }

    public TimeToPay getTimeToPay() {
        return timeToPay;
    }

    public LoanIsPaid getLoanIsPaid() {
        return loanIsPaid;
    }

    public IsAprobed getIsAprobed() {
        return isAprobed;
    }

    public SaleVerified getSaleVerified() {
        return saleVerified;
    }

    public AmountToPayPerMonth getAmountToPayPerMonth() {
        return amountToPayPerMonth;
    }
}
