package domain.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.cardealer.loan.Loan;
import domain.cardealer.loan.commands.UpdateLoaner;
import domain.cardealer.sale.Sale;

public class UpdateLoanerUseCase extends UseCase<RequestCommand<UpdateLoaner>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateLoaner> updateLoanerRequestCommand) {
        var command = updateLoanerRequestCommand.getCommand();

        var loan = Loan.from(command.getLoanId(), retrieveEvents());
        loan.updateLoaner(command.getLoanId(),command.getLoanerId(),command.getName(),
                command.getEmail(), command.getAge());
        emit().onResponse(new ResponseEvents(loan.getUncommittedChanges()));
    }
}
