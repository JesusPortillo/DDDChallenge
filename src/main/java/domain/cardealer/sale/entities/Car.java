package domain.cardealer.sale.entities;

import co.com.sofka.domain.generic.Entity;
import domain.cardealer.sale.values.*;



public class Car extends Entity<Plate> {

    protected CarModel carModel;
    protected CarPrice carPrice;
    protected CarColor carColor;
    protected Category category;


    public Car(Plate entityId, CarModel carModel, CarPrice carPrice, CarColor carColor, Category category) {
        super(entityId);
        this.carModel = carModel;
        this.carPrice = carPrice;
        this.carColor = carColor;
        this.category = category;
    }

    public CarModel carModel() {
        return carModel;
    }

    public void updateCarModel(CarModel carModel) {
        this.carModel = carModel;
    }

    public CarPrice carPrice() {
        return carPrice;
    }

    public void updateCarPrice(CarPrice carPrice) {
        this.carPrice = carPrice;
    }

    public CarColor carColor() {
        return carColor;
    }

    public void updateCarColor(CarColor carColor) {
        this.carColor = carColor;
    }

    public Category category() {
        return category;
    }

    public void updateCategory(Category category) {
        this.category = category;
    }

    public void updateCar(CarModel carModel, CarPrice carPrice, CarColor carColor, Category category){
        updateCarModel(carModel);
        updateCarPrice(carPrice);
        updateCarColor(carColor);
        updateCategory(category);
    }
}
