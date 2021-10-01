package domain.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.cardealer.loan.Loan;
import domain.cardealer.loan.commands.UpdateDebtor;

public class UpdateDebtorUseCase extends UseCase<RequestCommand<UpdateDebtor>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateDebtor> updateDebtorRequestCommand) {
        var command = updateDebtorRequestCommand.getCommand();
        var loan = Loan.from(command.getLoanId(), retrieveEvents(command.getDebtorId().value()));
        loan.updateDebtor(command.getLoanId(), command.getDebtorId(), command.getName(), command.getEmail(), command.getAge());
        emit().onResponse(new ResponseEvents(loan.getUncommittedChanges()));
    }
}
