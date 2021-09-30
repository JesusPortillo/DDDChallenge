package domain.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import domain.cardealer.generics.Age;
import domain.cardealer.generics.Email;
import domain.cardealer.generics.Name;
import domain.cardealer.sale.commands.UpdateCar;
import domain.cardealer.sale.commands.UpdateSalesman;
import domain.cardealer.sale.events.*;
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
class UpdateSalesmanUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    public void updateSalesman(){

        // arrange
        var command = new UpdateSalesman(
                SaleId.of("212"),
                new SalesmanId("121"),
                new Name("Ford"),
                new Email("foraquiesta@mail.co"),
                new Age("12")
        );
        var updateSalesmanUseCase = new UpdateSalesmanUseCase();
        Mockito.when(repository.getEventsBy("121")).thenReturn(events());
        updateSalesmanUseCase.addRepository(repository);

        // act
        var ev = UseCaseHandler.getInstance().setIdentifyExecutor("121")
                .syncExecutor(updateSalesmanUseCase,new RequestCommand<>(command)).orElseThrow().getDomainEvents();

        //assert
        var res = (SalesmanUpdated)ev.get(0);
        Assertions.assertEquals("121",res.getSalesmanId().value());
        Assertions.assertEquals("Ford",res.getName().value());
        Assertions.assertEquals("foraquiesta@mail.co",res.getEmail().value());
        Assertions.assertEquals("12",res.getAge().value());
    }

    private List<DomainEvent> events(){
        return List.of(new SaleCreated(new SaleDate()),
                new SalesmanAdded(SalesmanId.of("121"), new Name("Ford"), new Email("foraquiesta@mail.co"),
                        new Age("negro")));
    }

}