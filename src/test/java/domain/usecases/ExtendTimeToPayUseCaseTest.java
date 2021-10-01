package domain.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import domain.cardealer.generics.Age;
import domain.cardealer.generics.Email;
import domain.cardealer.generics.Name;
import domain.cardealer.loan.commands.ExtendTimeToPay;
import domain.cardealer.loan.commands.UpdateCoSign;
import domain.cardealer.loan.events.CoSignAdded;
import domain.cardealer.loan.events.CoSignUpdated;
import domain.cardealer.loan.events.LoanCreated;
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
class ExtendTimeToPayUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    public void updateLoanerEscenary(){
        var command = new ExtendTimeToPay(
                LoanId.of("212"),
                new TimeToPay("121")
        );
        var extendTimeToPayUseCase = new ExtendTimeToPayUseCase();
        Mockito.when(repository.getEventsBy("121")).thenReturn(events());
        extendTimeToPayUseCase.addRepository(repository);

        // act
        var ev = UseCaseHandler.getInstance().setIdentifyExecutor("121")
                .syncExecutor(extendTimeToPayUseCase,new RequestCommand<>(command)).orElseThrow().getDomainEvents();

        //assert
        var res = (TimeToPayExtended)ev.get(0);
        Assertions.assertEquals("121",res.getTimeToPay().value());
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