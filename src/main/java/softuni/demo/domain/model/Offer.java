package softuni.demo.domain.model;


import softuni.demo.domain.model.enums.Brand;
import softuni.demo.domain.model.enums.CarType;
import softuni.demo.domain.model.enums.EngineType;

import javax.persistence.*;

@Entity
@Table(name = "offers")
public class Offer extends BaseEntity {
        private Car car;
        private double price;
        private String description;


    @OneToOne
    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Column(nullable = false)
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Column(columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
