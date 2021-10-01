package domain.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.cardealer.loan.Loan;
import domain.cardealer.loan.commands.AddDebtor;

public class AddDebtorUseCase extends UseCase<RequestCommand<AddDebtor>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddDebtor> addDebtorRequestCommand) {
        var command = addDebtorRequestCommand.getCommand();
        var loan = Loan.from(command.getLoanId(), retrieveEvents(command.getDebtorId().value()));
        loan.addDebtor(command.getDebtorId(), command.getName(), command.getEmail(), command.getAge());
        emit().onResponse(new ResponseEvents(loan.getUncommittedChanges()));
    }
}
