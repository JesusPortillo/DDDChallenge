package domain.cardealer.loan.commands;

import co.com.sofka.domain.generic.Command;
import domain.cardealer.loan.values.LoanDate;
import domain.cardealer.loan.values.LoanId;

public class CreateLoan extends Command {

    private final LoanId loanId;
    private final LoanDate loanDate;

    public CreateLoan(LoanId loanId, LoanDate loanDate) {
        this.loanId = loanId;
        this.loanDate = loanDate;
    }

    public LoanId getLoanId() {
        return loanId;
    }

    public LoanDate getLoanDate() {
        return loanDate;
    }
}
