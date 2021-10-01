package domain.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.generic.DomainEvent;
import domain.cardealer.generics.Age;
import domain.cardealer.generics.Email;
import domain.cardealer.generics.Name;
import domain.cardealer.loan.events.CoSignAdded;
import domain.cardealer.loan.events.LoanCreated;
import domain.cardealer.loan.events.MessageSended;
import domain.cardealer.loan.events.TimeToPayExtended;
import domain.cardealer.loan.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class SendMessageByExtendTimeUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    public void sendMessageByExtendTimeToPay(){

        var aggregateId = "xx-xx";
        var event = new TimeToPayExtended(LoanId.of("212"), new TimeToPay("121"));

        event.setAggregateRootId(aggregateId);

        var sendMessageByExtendTimeUseCase = new SendMessageByExtendTimeUseCase();

        Mockito.when(repository.getEventsBy(aggregateId)).thenReturn(events());
        sendMessageByExtendTimeUseCase.addRepository(repository);

        var ev = UseCaseHandler.getInstance().setIdentifyExecutor(aggregateId).
                syncExecutor(sendMessageByExtendTimeUseCase, new TriggeredEvent<>(event)).orElseThrow().getDomainEvents();


        var messageSended = (MessageSended)ev.get(0);

        Assertions.assertEquals("Se ha extendido el plazo para pagar su deuda a un plazo de 121 meses", messageSended.getMessage());
        Mockito.verify(repository).getEventsBy(aggregateId);
    }
    private List<DomainEvent> events(){
        return List.of(new LoanCreated(
                        new LoanDate(),
                        new TimeToPay("12"),
                        new LoanIsPaid(false),
                        new IsAprobed(false),
                        new SaleVerified(false)));
    }
}