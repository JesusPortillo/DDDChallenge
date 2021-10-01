package domain.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.generic.DomainEvent;
import domain.cardealer.loan.Loan;
import domain.cardealer.loan.commands.ComputeFees;
import domain.cardealer.loan.events.FeesComputed;
import domain.cardealer.loan.events.LoanCreated;
import domain.cardealer.loan.values.*;
import domain.cardealer.sale.events.CarAdded;
import domain.cardealer.sale.events.SaleCreated;
import domain.cardealer.sale.events.TotalComputed;
import domain.cardealer.sale.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ComputeFeesUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    public void computeFeeBy24MonthsOrLessEscenary(){

        var command = new ComputeFees(LoanId.of("212"), new TimeToPay("24"));

        var computeFeesUseCase = new ComputeFeesUseCase();

        Mockito.when(repository.getEventsBy("212")).thenReturn(events());
        computeFeesUseCase.addRepository(repository);

        //act

        var events = UseCaseHandler.getInstance().setIdentifyExecutor("212")
                .syncExecutor(computeFeesUseCase, new RequestCommand<>(command)).orElseThrow().getDomainEvents();
        //assert
        var computed = (FeesComputed)events.get(0);
        Assertions.assertEquals(0.03, computed.getAmountToPayPerMonth().value());
        Mockito.verify(repository).getEventsBy("212");

    }

    @Test
    public void computeFeeByMoreThan24MonthsEscenary(){
        var command = new ComputeFees(LoanId.of("212"), new TimeToPay("25"));

        var computeFeesUseCase = new ComputeFeesUseCase();

        Mockito.when(repository.getEventsBy("212")).thenReturn(events());
        computeFeesUseCase.addRepository(repository);

        //act

        var events = UseCaseHandler.getInstance().setIdentifyExecutor("212")
                .syncExecutor(computeFeesUseCase, new RequestCommand<>(command)).orElseThrow().getDomainEvents();
        //assert
        var computed = (FeesComputed)events.get(0);
        Assertions.assertEquals(0.02, computed.getAmountToPayPerMonth().value());
        Mockito.verify(repository).getEventsBy("212");

    }
    private List<DomainEvent> events(){
        return List.of(new LoanCreated(
                new LoanDate(),
                new TimeToPay("12"),
                new LoanIsPaid(false),
                new IsAprobed(false),
                new SaleVerified(false),
                new AmountToPayPerMonth(0.0))
        );
    }

}