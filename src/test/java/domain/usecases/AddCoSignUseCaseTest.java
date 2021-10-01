package domain.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import domain.cardealer.generics.Age;
import domain.cardealer.generics.Email;
import domain.cardealer.generics.Name;
import domain.cardealer.loan.commands.AddCoSign;
import domain.cardealer.loan.commands.AddLoaner;
import domain.cardealer.loan.events.CoSignAdded;
import domain.cardealer.loan.events.LoanCreated;
import domain.cardealer.loan.events.LoanerAdded;
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
class AddCoSignUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    public void addCoSign(){

        // arrange
        var command = new AddCoSign(
                LoanId.of("212"),
                new CoSignId("121"),
                new Name("Ford"),
                new Email("foraquiesta@mail.co"),
                new Age("12")
        );
        var addCoSignUseCase = new AddCoSignUseCase();
        Mockito.when(repository.getEventsBy("121")).thenReturn(events());
        addCoSignUseCase.addRepository(repository);

        // act
        var ev = UseCaseHandler.getInstance().setIdentifyExecutor("121")
                .syncExecutor(addCoSignUseCase,new RequestCommand<>(command)).orElseThrow().getDomainEvents();

        //assert
        var res = (CoSignAdded)ev.get(0);
        Assertions.assertEquals("121",res.getCoSignId().value());
        Assertions.assertEquals("Ford",res.getName().value());
        Assertions.assertEquals("foraquiesta@mail.co",res.getEmail().value());
        Assertions.assertEquals("12",res.getAge().value());
        Mockito.verify(repository).getEventsBy("121");
    }

    private List<DomainEvent> events(){
        return List.of(new LoanCreated(new LoanDate(), new TimeToPay("0"), new LoanIsPaid(false),
                new IsAprobed(false), new SaleVerified(false), new AmountToPayPerMonth(0.0)));
    }

}