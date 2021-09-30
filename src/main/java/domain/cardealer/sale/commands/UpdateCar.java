package domain.cardealer.sale.commands;

import co.com.sofka.domain.generic.Command;
import domain.cardealer.sale.values.*;

public class UpdateCar extends Command {

    private final Plate plate;
    private final CarModel carModel;
    private final CarPrice carPrice;
    private final CarColor carColor;
    private final Category category;

    public UpdateCar(Plate plate, CarModel carModel, CarPrice carPrice, CarColor carColor, Category category) {
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
