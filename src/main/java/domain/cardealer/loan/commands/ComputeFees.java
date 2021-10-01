package domain.cardealer.loan.commands;

import co.com.sofka.domain.generic.Command;
import domain.cardealer.loan.values.AmountToPayPerMonth;
import domain.cardealer.loan.values.LoanId;
import domain.cardealer.loan.values.TimeToPay;
import domain.cardealer.sale.values.Total;

public class ComputeFees extends Command {


    private final LoanId loanId;
    private TimeToPay timeToPay;


    public ComputeFees(LoanId loanId,TimeToPay timeToPay) {
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
