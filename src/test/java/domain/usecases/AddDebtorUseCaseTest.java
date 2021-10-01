package domain.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import domain.cardealer.generics.Age;
import domain.cardealer.generics.Email;
import domain.cardealer.generics.Name;
import domain.cardealer.loan.commands.AddCoSign;
import domain.cardealer.loan.commands.AddDebtor;
import domain.cardealer.loan.events.CoSignAdded;
import domain.cardealer.loan.events.DebtorAdded;
import domain.cardealer.loan.events.LoanCreated;
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
class AddDebtorUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    public void addDebtor(){

        // arrange
        var command = new AddDebtor(
                LoanId.of("212"),
                new DebtorId("121"),
                new Name("Ford"),
                new Email("foraquiesta@mail.co"),
                new Age("12")
        );
        var addDebtorUseCase = new AddDebtorUseCase();
        Mockito.when(repository.getEventsBy("121")).thenReturn(events());
        addDebtorUseCase.addRepository(repository);

        // act
        var ev = UseCaseHandler.getInstance().setIdentifyExecutor("121")
                .syncExecutor(addDebtorUseCase,new RequestCommand<>(command)).orElseThrow().getDomainEvents();

        //assert
        var res = (DebtorAdded)ev.get(0);
        Assertions.assertEquals("121",res.getDebtorId().value());
        Assertions.assertEquals("Ford",res.getName().value());
        Assertions.assertEquals("foraquiesta@mail.co",res.getEmail().value());
        Assertions.assertEquals("12",res.getAge().value());
    }

    private List<DomainEvent> events(){
        return List.of(new LoanCreated(new LoanDate(), new TimeToPay("0"), new LoanIsPaid(false),
                new IsAprobed(false), new SaleVerified(false)));
    }

}