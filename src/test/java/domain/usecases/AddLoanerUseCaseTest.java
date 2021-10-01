package domain.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import domain.cardealer.generics.Age;
import domain.cardealer.generics.Email;
import domain.cardealer.generics.Name;
import domain.cardealer.loan.commands.AddLoaner;
import domain.cardealer.loan.events.LoanCreated;
import domain.cardealer.loan.events.LoanerAdded;
import domain.cardealer.loan.values.*;
import domain.cardealer.sale.commands.AddCar;
import domain.cardealer.sale.events.CarAdded;
import domain.cardealer.sale.events.SaleCreated;
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
class AddLoanerUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    public void addLoaner(){

        // arrange
        var command = new AddLoaner(
                LoanId.of("212"),
                new LoanerId("121"),
                new Name("Ford"),
                new Email("foraquiesta@mail.co"),
                new Age("12")
        );
        var addLoanerUseCase = new AddLoanerUseCase();
        Mockito.when(repository.getEventsBy("121")).thenReturn(events());
        addLoanerUseCase.addRepository(repository);

        // act
        var ev = UseCaseHandler.getInstance().setIdentifyExecutor("121")
                .syncExecutor(addLoanerUseCase,new RequestCommand<>(command)).orElseThrow().getDomainEvents();

        //assert
        var res = (LoanerAdded)ev.get(0);
        Assertions.assertEquals("121",res.getLoanerId().value());
        Assertions.assertEquals("Ford",res.getName().value());
        Assertions.assertEquals("foraquiesta@mail.co",res.getEmail().value());
        Assertions.assertEquals("12",res.getAge().value());
    }

    private List<DomainEvent> events(){
        return List.of(new LoanCreated(new LoanDate(), new TimeToPay("0"), new LoanIsPaid(false),
                new IsAprobed(false), new SaleVerified(false)));
    }
}