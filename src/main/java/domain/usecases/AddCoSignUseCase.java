package domain.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.cardealer.loan.Loan;
import domain.cardealer.loan.commands.AddCoSign;

public class AddCoSignUseCase extends UseCase<RequestCommand<AddCoSign>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddCoSign> addCoSignRequestCommand) {
        var command = addCoSignRequestCommand.getCommand();
        var loan = Loan.from(command.getLoanId(), retrieveEvents(command.getCoSignId().value()));
        loan.addCoSign(command.getCoSignId(), command.getName(), command.getEmail(), command.getAge());
        emit().onResponse(new ResponseEvents(loan.getUncommittedChanges()));
    }
}
