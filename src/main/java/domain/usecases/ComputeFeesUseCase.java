package domain.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.cardealer.loan.Loan;
import domain.cardealer.loan.commands.ComputeFees;
import domain.cardealer.loan.values.AmountToPayPerMonth;
import domain.cardealer.loan.values.LoanId;
import domain.cardealer.loan.values.TimeToPay;

public class ComputeFeesUseCase extends UseCase<RequestCommand<ComputeFees>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ComputeFees> computeFeesRequestCommand) {
        var command = computeFeesRequestCommand.getCommand();
        var loan = Loan.from(command.getLoanId(), retrieveEvents());

        AmountToPayPerMonth amountToPayPerMonth = null;
        if (Integer.parseInt(command.getTimeToPay().value()) <= 24){
            loan.computeFees(new AmountToPayPerMonth(0.03));
        }
        if (Integer.parseInt(command.getTimeToPay().value()) > 24)
            loan.computeFees(new AmountToPayPerMonth(0.02));

        emit().onResponse(new ResponseEvents(loan.getUncommittedChanges()));
    }
}
