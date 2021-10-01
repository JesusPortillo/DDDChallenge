package domain.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import domain.cardealer.sale.commands.UpdateCar;
import domain.cardealer.sale.events.CarAdded;
import domain.cardealer.sale.events.CarUpdated;
import domain.cardealer.sale.events.SaleCreated;
import domain.cardealer.sale.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;



@ExtendWith(MockitoExtension.class)
class UpdateCarUseCaseTest {
    @Mock
    private DomainEventRepository repository;

    @Test
    public void createCar(){

        // arrange
        var command = new UpdateCar(
                SaleId.of("212"),
                new Plate("121"),
                new CarModel("Ford"),
                new CarPrice(123000000.0),
                new CarColor("negro"),
                new Category("deportivo")
        );
        var updateCarUseCase = new UpdateCarUseCase();
        Mockito.when(repository.getEventsBy("121")).thenReturn(events());
        updateCarUseCase.addRepository(repository);

        // act
        var ev = UseCaseHandler.getInstance().setIdentifyExecutor("121")
                .syncExecutor(updateCarUseCase,new RequestCommand<>(command)).orElseThrow().getDomainEvents();

        //assert
        var res = (CarUpdated)ev.get(0);
        Assertions.assertEquals("121",res.getPlate().value());
        Assertions.assertEquals("Ford",res.getCarModel().value());
        Assertions.assertEquals(123000000.0,res.getCarPrice().value());
        Assertions.assertEquals("negro",res.getCarColor().value());
        Assertions.assertEquals("deportivo",res.getCategory().value());
        Mockito.verify(repository).getEventsBy("121");

    }

    private List<DomainEvent> events(){
        return List.of(new SaleCreated(new SaleDate()),
                new CarAdded(Plate.of("121"), new CarModel("Nissan"), new CarPrice(123000000.0),
                        new CarColor("negro"), new Category("deportivo")));
    }
}