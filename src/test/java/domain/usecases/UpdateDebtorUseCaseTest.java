package domain.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import domain.cardealer.generics.Age;
import domain.cardealer.generics.Email;
import domain.cardealer.generics.Name;
import domain.cardealer.loan.commands.UpdateDebtor;
import domain.cardealer.loan.commands.UpdateLoaner;
import domain.cardealer.loan.events.*;
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
class UpdateDebtorUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    public void updateDebtorEscenary(){
        var command = new UpdateDebtor(
                LoanId.of("212"),
                new DebtorId("121"),
                new Name("Ford"),
                new Email("foraquiesta@mail.co"),
                new Age("21")
        );
        var updateDebtorUseCase = new UpdateDebtorUseCase();
        Mockito.when(repository.getEventsBy("121")).thenReturn(events());
        updateDebtorUseCase.addRepository(repository);

        // act
        var ev = UseCaseHandler.getInstance().setIdentifyExecutor("121")
                .syncExecutor(updateDebtorUseCase,new RequestCommand<>(command)).orElseThrow().getDomainEvents();

        //assert
        var res = (DebtorUpdated)ev.get(0);
        Assertions.assertEquals("121",res.getDebtorId().value());
        Assertions.assertEquals("Ford",res.getName().value());
        Assertions.assertEquals("foraquiesta@mail.co",res.getEmail().value());
        Assertions.assertEquals("21",res.getAge().value());
        Mockito.verify(repository).getEventsBy("121");
    }

    private List<DomainEvent> events(){
        return List.of(new LoanCreated(
                        new LoanDate(),
                        new TimeToPay("12"),
                        new LoanIsPaid(false),
                        new IsAprobed(false),
                        new SaleVerified(false),
                        new AmountToPayPerMonth(0.0)),
                new DebtorAdded(DebtorId.of("121"), new Name("Ford"), new Email("jeuswsnw@mail.co"),
                        new Age("negro")));
    }
}