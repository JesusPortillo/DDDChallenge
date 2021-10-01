package domain.cardealer.loan.commands;

import co.com.sofka.domain.generic.Command;
import domain.cardealer.loan.values.IsAprobed;
import domain.cardealer.loan.values.LoanId;

public class ApproveLoan extends Command {

    private final LoanId loanId;
    private final IsAprobed isAprobed;

    public ApproveLoan(LoanId loanId, IsAprobed isAprobed) {
        this.loanId = loanId;
        this.isAprobed = isAprobed;
    }

    public LoanId getLoanId() {
        return loanId;
    }

    public IsAprobed getIsAprobed() {
        return isAprobed;
    }
}
