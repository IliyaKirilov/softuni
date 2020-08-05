package softuni.demo.service.model;

import softuni.demo.domain.model.Car;

public class OfferServiceModel {

    private CarServiceModel car;
    private double price;
    private String description;

    public OfferServiceModel() {
    }

    public CarServiceModel getCar() {
        return car;
    }

    public void setCar(CarServiceModel car) {
        this.car = car;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
