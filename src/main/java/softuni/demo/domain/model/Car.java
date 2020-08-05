package softuni.demo.domain.model;

import softuni.demo.domain.model.enums.Brand;
import softuni.demo.domain.model.enums.CarType;
import softuni.demo.domain.model.enums.EngineType;
import softuni.demo.domain.model.enums.TransmissionType;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car extends BaseEntity{
      private String model;
    private Brand brand;
    private int yearOfProduction;
    private int mileage;
    private String imgUrl;
    private CarType carType;
    private EngineType engineType;
    private TransmissionType transmissionType;


    @Enumerated(EnumType.STRING)
    public TransmissionType getTransmissionType() {
        return transmissionType;
    }

    public void setTransmissionType(TransmissionType transmissionType) {
        this.transmissionType = transmissionType;
    }

    public Car() {
    }

    @Column(name = "year_of_production", nullable = false)
    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    @Column(nullable = false)
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Enumerated(EnumType.STRING)
    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    @Column(nullable = false)
    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    @Column(columnDefinition = "TEXT")
    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Enumerated(EnumType.STRING)
    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }
    @Enumerated(EnumType.STRING)
    public EngineType getEngineType() {
        return engineType;
    }

    public void setEngineType(EngineType engineType) {
        this.engineType = engineType;
    }
}
