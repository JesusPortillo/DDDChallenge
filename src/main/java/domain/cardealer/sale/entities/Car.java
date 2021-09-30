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

    public CarModel CarModel() {
        return carModel;
    }

    public void setCarModel(CarModel carModel) {
        this.carModel = carModel;
    }

    public CarPrice CarPrice() {
        return carPrice;
    }

    public void setCarPrice(CarPrice carPrice) {
        this.carPrice = carPrice;
    }

    public CarColor CarColor() {
        return carColor;
    }

    public void setCarColor(CarColor carColor) {
        this.carColor = carColor;
    }

    public Category Category() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void updateCar(CarModel carModel, CarPrice carPrice, CarColor carColor, Category category){
        setCarModel(carModel);
        setCarPrice(carPrice);
        setCarColor(carColor);
        setCategory(category);
    }
}
