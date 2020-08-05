package softuni.demo.web.model;

import org.hibernate.validator.constraints.Length;
import softuni.demo.domain.model.enums.Brand;
import softuni.demo.domain.model.enums.CarType;
import softuni.demo.domain.model.enums.EngineType;
import softuni.demo.domain.model.enums.TransmissionType;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class CarAddModel {
    private String model;
    private Brand brand;
    private int yearOfProduction;
    private int mileage;
    private String imgUrl;
    private CarType carType;
    private EngineType engineType;
    private TransmissionType transmissionType;


    @Min(value = 0, message = "Year of production cannot be negative!")
    @Max(value = 2020,message = "Whoa!Seems like you like future!")
    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public TransmissionType getTransmissionType() {
        return transmissionType;
    }

    public void setTransmissionType(TransmissionType transmissionType) {
        this.transmissionType = transmissionType;
    }

    public CarAddModel() {
    }

    @Length(min = 2, message = "Model length must be more than 1 charachter")
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    @Min(value = 0, message = "Mileage cannot be negative!")
    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public EngineType getEngineType() {
        return engineType;
    }

    public void setEngineType(EngineType engineType) {
        this.engineType = engineType;
    }
}



