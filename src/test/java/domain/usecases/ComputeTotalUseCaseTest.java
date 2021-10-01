package domain.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.generic.DomainEvent;
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
class ComputeTotalUseCaseTest {

    @Mock
    private DomainEventRepository repository;

    @Test
    public void computeTotalEscenary(){
        var aggregateId = "xx-xx";
        var event = new CarAdded(new Plate("121"),
                new CarModel("Ford"),
                new CarPrice(123000000.0),
                new CarColor("negro"),
                new Category("deportivo"));
        event.setAggregateRootId(aggregateId);
        var computeTotalUseCase = new ComputeTotalUseCase();

        Mockito.when(repository.getEventsBy(aggregateId)).thenReturn(events());
        computeTotalUseCase.addRepository(repository);

        //act

        var events = UseCaseHandler.getInstance().setIdentifyExecutor(aggregateId)
                .syncExecutor(computeTotalUseCase, new TriggeredEvent<>(event)).orElseThrow().getDomainEvents();
        //assert
        var computed = (TotalComputed)events.get(0);
        Assertions.assertEquals(246000000.0, computed.getTotal().value());
        Mockito.verify(repository).getEventsBy(aggregateId);

    }

    @Test
    public void noComputeTotalEscenary(){
        var aggregateId = "xx-xx";
        var event = new CarAdded(new Plate("121"),
                new CarModel("Ford"),
                new CarPrice(123000000.0),
                new CarColor("negro"),
                new Category("deportivo"));
        event.setAggregateRootId(aggregateId);
        var computeTotalUseCase = new ComputeTotalUseCase();

        Mockito.when(repository.getEventsBy(aggregateId)).thenReturn(eventsWithoutCars());
        computeTotalUseCase.addRepository(repository);

        //act

        var events = UseCaseHandler.getInstance().setIdentifyExecutor(aggregateId)
                .syncExecutor(computeTotalUseCase, new TriggeredEvent<>(event)).orElseThrow().getDomainEvents();
        //assert
        var computed = (TotalComputed)events.get(0);
        Assertions.assertEquals(0.0, computed.getTotal().value());
        Mockito.verify(repository).getEventsBy(aggregateId);

    }
    private List<DomainEvent> events(){
        return List.of(new SaleCreated(new SaleDate()), new CarAdded(
                new Plate("121"),
                new CarModel("Ford"),
                new CarPrice(123000000.0),
                new CarColor("negro"),
                new Category("deportivo")

        ),new CarAdded(
                new Plate("11"),
                new CarModel("Ford"),
                new CarPrice(123000000.0),
                new CarColor("negro"),
                new Category("deportivo")));
    }
    private List<DomainEvent> eventsWithoutCars(){
        return List.of(new SaleCreated(new SaleDate()));
    }

}