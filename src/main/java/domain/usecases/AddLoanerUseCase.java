package domain.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.cardealer.loan.Loan;
import domain.cardealer.loan.commands.AddLoaner;
import domain.cardealer.sale.Sale;

public class AddLoanerUseCase extends UseCase<RequestCommand<AddLoaner>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddLoaner> addLoanerRequestCommand) {
        var command = addLoanerRequestCommand.getCommand();
        var loan = Loan.from(command.getLoanId(), retrieveEvents(command.getLoanerId().value()));
        loan.addLoaner(command.getLoanerId(), command.getName(), command.getEmail(), command.getAge());
        emit().onResponse(new ResponseEvents(loan.getUncommittedChanges()));
    }
}
