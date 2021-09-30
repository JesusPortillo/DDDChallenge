package domain.cardealer.sale;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import domain.cardealer.sale.entities.Car;
import domain.cardealer.sale.entities.Customer;
import domain.cardealer.sale.entities.Salesman;
import domain.cardealer.sale.events.CarAdded;
import domain.cardealer.sale.events.CarUpdated;
import domain.cardealer.sale.events.SaleCreated;
import domain.cardealer.sale.values.*;

import java.util.List;
import java.util.Objects;

public class Sale extends AggregateEvent<SaleId> {

    protected SaleDate saleDate;
    protected List<Car> cars;
    protected Salesman salesman;
    protected Customer customer;
    protected SaleVerified saleVerified;
    protected Total total;

    public Sale(SaleId entityId, SaleDate saleDate) {
        super(entityId);
        appendChange(new SaleCreated(saleDate)).apply();
    }

    private Sale(SaleId entityId){
        super(entityId);
        subscribe(new SaleChange(this));
    }

    public static Sale from(SaleId saleId, List<DomainEvent> events){
        Sale sale = new Sale(saleId);
        events.forEach(sale::applyEvent);
        return sale;
    }

    public void addCar(Plate plate, CarModel carModel, CarPrice carPrice, CarColor carColor, Category category){
        Objects.requireNonNull(plate);
        Objects.requireNonNull(carModel);
        Objects.requireNonNull(carPrice);
        Objects.requireNonNull(carColor);
        Objects.requireNonNull(category);
        appendChange(new CarAdded(plate, carModel, carPrice, carColor, category)).apply();
    }

    public void updateCar(Plate plate, CarModel carModel, CarPrice carPrice, CarColor carColor, Category category){
        Objects.requireNonNull(plate);
        Objects.requireNonNull(carModel);
        Objects.requireNonNull(carPrice);
        Objects.requireNonNull(carColor);
        Objects.requireNonNull(category);
        appendChange(new CarUpdated(plate, carModel, carPrice, carColor, category)).apply();
    }


}
