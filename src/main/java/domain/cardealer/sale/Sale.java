package domain.cardealer.sale;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import domain.cardealer.generics.Age;
import domain.cardealer.generics.Email;
import domain.cardealer.generics.Name;
import domain.cardealer.sale.entities.Car;
import domain.cardealer.sale.entities.Customer;
import domain.cardealer.sale.entities.Salesman;
import domain.cardealer.sale.events.*;
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

    public void updateCar(SaleId saleId, Plate plate, CarModel carModel, CarPrice carPrice, CarColor carColor, Category category){
        Objects.requireNonNull(saleId);
        Objects.requireNonNull(plate);
        Objects.requireNonNull(carModel);
        Objects.requireNonNull(carPrice);
        Objects.requireNonNull(carColor);
        Objects.requireNonNull(category);
        appendChange(new CarUpdated(saleId, plate, carModel, carPrice, carColor, category)).apply();
    }

    public void addSalesman(SalesmanId salesmanId, Name name, Email email, Age age){
        Objects.requireNonNull(salesmanId);
        Objects.requireNonNull(name);
        Objects.requireNonNull(email);
        Objects.requireNonNull(age);
        appendChange(new SalesmanAdded(salesmanId, name, email, age)).apply();
    }

    public void updateSalesman(SaleId saleId, SalesmanId salesmanId, Name name, Email email, Age age){
        Objects.requireNonNull(saleId);
        Objects.requireNonNull(salesmanId);
        Objects.requireNonNull(name);
        Objects.requireNonNull(email);
        Objects.requireNonNull(age);
        appendChange(new SalesmanUpdated(saleId, salesmanId, name, email, age)).apply();
    }

    public void addCustomer(CustomerId customerId, Name name, Email email, Age age){
        Objects.requireNonNull(customerId);
        Objects.requireNonNull(name);
        Objects.requireNonNull(email);
        Objects.requireNonNull(age);
        appendChange(new CustomerAdded(customerId, name, email, age)).apply();
    }

    public void updateCustomer(SaleId saleId, CustomerId customerId, Name name, Email email, Age age){
        Objects.requireNonNull(saleId);
        Objects.requireNonNull(customerId);
        Objects.requireNonNull(name);
        Objects.requireNonNull(email);
        Objects.requireNonNull(age);
        appendChange(new CustomerUpdated(saleId, customerId, name, email, age)).apply();
    }

    public Car getCarId(Plate plate) {
        Objects.requireNonNull(plate);
        return cars().stream().filter(car -> car.identity().equals(plate)).findFirst().orElseThrow();
    }

    public void computeTotal(Total total){
        Objects.requireNonNull(total);

        appendChange(new TotalComputed(total)).apply();
    }

    public List<Car> cars() {
        return cars;
    }
}
