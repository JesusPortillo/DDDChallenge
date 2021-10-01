package domain.cardealer.sale;

import co.com.sofka.domain.generic.EventChange;
import domain.cardealer.sale.entities.Car;
import domain.cardealer.sale.entities.Customer;
import domain.cardealer.sale.entities.Salesman;
import domain.cardealer.sale.events.*;

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

        apply((CarUpdated event)->{
            sale.getCarId(event.getPlate()).updateCar(event.getCarModel(), event.getCarPrice(),
                    event.getCarColor(), event.getCategory());
        });

        apply((SalesmanAdded event) -> {
            sale.salesman = new Salesman(event.getSalesmanId(), event.getName(), event.getEmail(), event.getAge());
        });

        apply((SalesmanUpdated event)->{
            sale.salesman.updateSalesman(event.getName(), event.getEmail(), event.getAge());
        });

        apply((CustomerAdded event) ->{
            sale.customer = new Customer(event.getCustomerId(), event.getName(), event.getEmail(), event.getAge());
        });

        apply((CustomerUpdated event) ->{
            sale.customer.updateCustomer(event.getName(), event.getEmail(), event.getAge());
        });
    }
}
