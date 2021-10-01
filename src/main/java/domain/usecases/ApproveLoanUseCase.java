package domain.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.cardealer.loan.Loan;
import domain.cardealer.loan.commands.ApproveLoan;

public class ApproveLoanUseCase extends UseCase<RequestCommand<ApproveLoan>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ApproveLoan> approveLoanRequestCommand) {
        var command = approveLoanRequestCommand.getCommand();
        var loan = Loan.from(command.getLoanId(), retrieveEvents());
        loan.approveLoan(command.getIsAprobed(), command.getSaleVerified());
        emit().onResponse(new ResponseEvents(loan.getUncommittedChanges()));
    }
}
