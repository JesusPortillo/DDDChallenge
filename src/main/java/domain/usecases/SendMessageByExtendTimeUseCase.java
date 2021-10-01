package domain.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import domain.cardealer.loan.Loan;
import domain.cardealer.loan.events.TimeToPayExtended;
import domain.cardealer.loan.values.LoanId;

public class SendMessageByExtendTimeUseCase extends UseCase<TriggeredEvent<TimeToPayExtended>, ResponseEvents> {



    @Override
    public void executeUseCase(TriggeredEvent<TimeToPayExtended> timeToPayExtendedTriggeredEvent) {
        var event = timeToPayExtendedTriggeredEvent.getDomainEvent();
        var loan = Loan.from(LoanId.of(event.aggregateRootId()),this.retrieveEvents());
        String MESSAGE = "Se ha extendido el plazo para pagar su deuda a un plazo de "+ event.getTimeToPay().value()+" meses";
        loan.sendMessageByExtendTime(MESSAGE);
        emit().onResponse(new ResponseEvents(loan.getUncommittedChanges()));
    }
}
