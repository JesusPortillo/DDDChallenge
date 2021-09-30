package domain.cardealer.sale.events;

import co.com.sofka.domain.generic.DomainEvent;
import domain.cardealer.sale.values.*;

public class CarAdded extends DomainEvent {

    private final Plate plate;
    private final CarModel carModel;
    private final CarPrice carPrice;
    private final CarColor carColor;
    private final Category category;

    public CarAdded(Plate plate, CarModel carModel, CarPrice carPrice, CarColor carColor, Category category) {
        super("domain.cardealer.sale.caradded");
        this.plate = plate;
        this.carModel = carModel;
        this.carPrice = carPrice;
        this.carColor = carColor;
        this.category = category;
    }


    public Plate getPlate() {
        return plate;
    }

    public CarModel getCarModel() {
        return carModel;
    }

    public CarPrice getCarPrice() {
        return carPrice;
    }

    public CarColor getCarColor() {
        return carColor;
    }

    public Category getCategory() {
        return category;
    }
}
