package domain.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import domain.cardealer.generics.Age;
import domain.cardealer.generics.Email;
import domain.cardealer.generics.Name;
import domain.cardealer.loan.commands.ApproveLoan;
import domain.cardealer.loan.events.LoanApproved;
import domain.cardealer.loan.events.LoanCreated;
import domain.cardealer.loan.values.*;
import domain.cardealer.sale.commands.AddSalesman;
import domain.cardealer.sale.events.SaleCreated;
import domain.cardealer.sale.events.SalesmanAdded;
import domain.cardealer.sale.values.SaleDate;
import domain.cardealer.sale.values.SaleId;
import domain.cardealer.sale.values.SalesmanId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ApproveLoanUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    public void approveLoanEscenary(){
        // arrange
        var command = new ApproveLoan(
                LoanId.of("121"),
                new IsAprobed(true)
        );
        var approveLoanUseCase = new ApproveLoanUseCase();
        Mockito.when(repository.getEventsBy("121")).thenReturn(events());
        approveLoanUseCase.addRepository(repository);

        // act
        var ev = UseCaseHandler.getInstance().setIdentifyExecutor("121")
                .syncExecutor(approveLoanUseCase,new RequestCommand<>(command)).orElseThrow().getDomainEvents();

        //assert
        var res = (LoanApproved)ev.get(0);
        Assertions.assertEquals(true,res.getIsAprobed().value());
        Mockito.verify(repository).getEventsBy("121");
    }

    private List<DomainEvent> events(){
        return List.of(new LoanCreated(new LoanDate(), new TimeToPay("0"), new LoanIsPaid(false),
                new IsAprobed(false), new SaleVerified(false), new AmountToPayPerMonth(0.0)));
    }
}