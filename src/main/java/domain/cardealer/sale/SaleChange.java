package domain.cardealer.sale;

import co.com.sofka.domain.generic.EventChange;
import domain.cardealer.sale.entities.Car;
import domain.cardealer.sale.events.CarAdded;
import domain.cardealer.sale.events.SaleCreated;

import java.util.ArrayList;

public class SaleChange extends EventChange {

    public SaleChange(Sale sale) {

        apply((SaleCreated event) -> {
            sale.saleDate = event.getSaleDate();
            sale.cars = new ArrayList<>();
        });

        apply((CarAdded event) -> {
            sale.cars.add(new Car(event.getPlate(), event.getCarModel(), event.getCarPrice(), event.getCarColor(),
                    event.getCategory()));

        });


    }
}
