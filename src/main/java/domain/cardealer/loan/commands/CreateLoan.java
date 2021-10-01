package domain.cardealer.loan.commands;

import co.com.sofka.domain.generic.Command;
import domain.cardealer.loan.values.*;

public class CreateLoan extends Command {

    private final LoanId loanId;
    private final LoanDate loanDate;
    private final TimeToPay timeToPay;
    private final LoanIsPaid loanIsPaid;
    private final IsAprobed isAprobed;
    private final SaleVerified saleVerified;


    public CreateLoan(LoanId loanId, LoanDate loanDate, TimeToPay timeToPay, LoanIsPaid loanIsPaid,
                      IsAprobed isAprobed, SaleVerified saleVerified) {
        this.loanId = loanId;
        this.loanDate = loanDate;
        this.timeToPay = timeToPay;
        this.loanIsPaid = loanIsPaid;
        this.isAprobed = isAprobed;
        this.saleVerified = saleVerified;
    }

    public LoanId getLoanId() {
        return loanId;
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
}
