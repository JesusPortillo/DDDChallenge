package domain.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import domain.cardealer.generics.Age;
import domain.cardealer.generics.Email;
import domain.cardealer.generics.Name;
import domain.cardealer.sale.commands.AddCar;
import domain.cardealer.sale.commands.AddCustomer;
import domain.cardealer.sale.events.CarAdded;
import domain.cardealer.sale.events.CustomerAdded;
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
class AddCustomerUseCaseTest {


    @Mock
    private DomainEventRepository repository;

    @Test
    public void createCustomer(){

        // arrange
        var command = new AddCustomer(
                SaleId.of("212"),
                new CustomerId("121"),
                new Name("Ford"),
                new Email("foraquiesta@mail.co"),
                new Age("12")
        );
        var addCustomerUseCase = new AddCustomerUseCase();
        Mockito.when(repository.getEventsBy("121")).thenReturn(events());
        addCustomerUseCase.addRepository(repository);

        // act
        var ev = UseCaseHandler.getInstance().setIdentifyExecutor("121")
                .syncExecutor(addCustomerUseCase,new RequestCommand<>(command)).orElseThrow().getDomainEvents();

        //assert
        var res = (CustomerAdded)ev.get(0);
        Assertions.assertEquals("121",res.getCustomerId().value());
        Assertions.assertEquals("Ford",res.getName().value());
        Assertions.assertEquals("foraquiesta@mail.co",res.getEmail().value());
        Assertions.assertEquals("12",res.getAge().value());
        Mockito.verify(repository).getEventsBy("121");
    }

    private List<DomainEvent> events(){
        return List.of(new SaleCreated(new SaleDate()));
    }
}