package domain.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import domain.cardealer.loan.Loan;
import domain.cardealer.loan.commands.UpdateCoSign;

public class UpdateCoSignUseCase extends UseCase<RequestCommand<UpdateCoSign>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpdateCoSign> updateCoSignRequestCommand) {
        var command = updateCoSignRequestCommand.getCommand();
        var loan = Loan.from(command.getLoanId(), retrieveEvents());
        loan.updateCosign(command.getLoanId(),command.getCoSignId(),command.getName(),
                command.getEmail(), command.getAge());
        emit().onResponse(new ResponseEvents(loan.getUncommittedChanges()));
    }
}
