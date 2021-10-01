package domain.cardealer.loan.commands;

import co.com.sofka.domain.generic.Command;
import domain.cardealer.loan.values.IsAprobed;
import domain.cardealer.loan.values.LoanId;
import domain.cardealer.loan.values.SaleVerified;

public class ApproveLoan extends Command {

    private final LoanId loanId;
    private final IsAprobed isAprobed;
    private final SaleVerified saleVerified;

    public ApproveLoan(LoanId loanId, IsAprobed isAprobed, SaleVerified saleVerified) {
        this.loanId = loanId;
        this.isAprobed = isAprobed;
        this.saleVerified = saleVerified;
    }

    public LoanId getLoanId() {
        return loanId;
    }

    public IsAprobed getIsAprobed() {
        return isAprobed;
    }

    public SaleVerified getSaleVerified() {
        return saleVerified;
    }
}
