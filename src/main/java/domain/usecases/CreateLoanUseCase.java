package domain.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.cardealer.loan.Loan;
import domain.cardealer.loan.commands.CreateLoan;

public class CreateLoanUseCase extends UseCase<RequestCommand<CreateLoan>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CreateLoan> createLoanRequestCommand) {
        var command = createLoanRequestCommand.getCommand();

        var loan = new Loan(command.getLoanId(), command.getLoanDate(), command.getTimeToPay(), command.getLoanIsPaid(),
                command.getIsAprobed(), command.getSaleVerified(), command.getAmountToPayPerMonth());
        emit().onResponse(new ResponseEvents(loan.getUncommittedChanges()));
    }
}
