package domain.cardealer.loan.commands;

import co.com.sofka.domain.generic.Command;
import domain.cardealer.loan.values.LoanId;
import domain.cardealer.loan.values.TimeToPay;

public class ExtendTimeToPay extends Command {

    private final LoanId loanId;
    private final TimeToPay timeToPay;

    public ExtendTimeToPay(LoanId loanId, TimeToPay timeToPay) {
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
