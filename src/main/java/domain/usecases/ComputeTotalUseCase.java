package domain.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import domain.cardealer.sale.Sale;
import domain.cardealer.sale.entities.Car;
import domain.cardealer.sale.events.CarAdded;
import domain.cardealer.sale.events.SaleCreated;
import domain.cardealer.sale.values.SaleId;
import domain.cardealer.sale.values.Total;

public class ComputeTotalUseCase extends UseCase<TriggeredEvent<CarAdded>, ResponseEvents> {

    @Override
    public void executeUseCase(TriggeredEvent<CarAdded> computeTotalTriggeredEvent) {
        var event = computeTotalTriggeredEvent.getDomainEvent();
        var sale = Sale.from(SaleId.of(event.aggregateRootId()), this.retrieveEvents());

        Double totalAux = 0D;
        if (!sale.cars().isEmpty()){
            for (Car car: sale.cars()) {
                totalAux += car.CarPrice().value();
            }
        }
        sale.computeTotal(new Total(totalAux));
        emit().onResponse(new ResponseEvents(sale.getUncommittedChanges()));
    }
}
