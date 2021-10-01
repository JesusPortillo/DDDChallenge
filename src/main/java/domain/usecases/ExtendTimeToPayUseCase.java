package domain.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.cardealer.loan.Loan;
import domain.cardealer.loan.commands.ExtendTimeToPay;

public class ExtendTimeToPayUseCase extends UseCase<RequestCommand<ExtendTimeToPay>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ExtendTimeToPay> extendTimeToPayRequestCommand) {
        var command = extendTimeToPayRequestCommand.getCommand();
        var loan = Loan.from(command.getLoanId(), retrieveEvents());
        loan.extendTimeToPay(command.getLoanId(),command.getTimeToPay());
        emit().onResponse(new ResponseEvents(loan.getUncommittedChanges()));
    }
}
