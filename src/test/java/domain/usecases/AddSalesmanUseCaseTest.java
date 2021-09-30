package domain.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import domain.cardealer.generics.Age;
import domain.cardealer.generics.Email;
import domain.cardealer.generics.Name;
import domain.cardealer.sale.commands.AddSalesman;
import domain.cardealer.sale.events.SaleCreated;
import domain.cardealer.sale.events.SalesmanAdded;
import domain.cardealer.sale.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;



@ExtendWith(MockitoExtension.class)
class AddSalesmanUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    public void createSalesman(){

        // arrange
        var command = new AddSalesman(
                SaleId.of("212"),
                new SalesmanId("121"),
                new Name("Ford"),
                new Email("foraquiesta@mail.co"),
                new Age("negro")
        );
        var addSalesmanUseCase = new AddSalesmanUseCase();
        Mockito.when(repository.getEventsBy("121")).thenReturn(events());
        addSalesmanUseCase.addRepository(repository);

        // act
        var ev = UseCaseHandler.getInstance().setIdentifyExecutor("121")
                .syncExecutor(addSalesmanUseCase,new RequestCommand<>(command)).orElseThrow().getDomainEvents();

        //assert
        var res = (SalesmanAdded)ev.get(0);
        Assertions.assertEquals("121",res.getSalesmanId().value());
        Assertions.assertEquals("Ford",res.getName().value());
        Assertions.assertEquals("foraquiesta@mail.co",res.getEmail().value());
        Assertions.assertEquals("negro",res.getAge().value());
    }

    private List<DomainEvent> events(){
        return List.of(new SaleCreated(new SaleDate()));
    }
}