package softuni.demo.web.model;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDateTime;

public class RaceAddModel {
    private String country;
    private String city;
    private String name;
    private int carsCapacity;
    private int laps;
    private int lapRange;
    private LocalDateTime startedOn;
    private LocalDateTime dueDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @PastOrPresent(message = "The date cannot be in the future!")
    public LocalDateTime getStartedOn() {
        return startedOn;
    }

    public void setStartedOn(LocalDateTime startedOn) {
        this.startedOn = startedOn;
    }
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @FutureOrPresent(message = "The date cannot be in the past!")
    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    @Length(min = 3, message = "The country name should be more than 2 characters!")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    @Length(min = 3, message = "The city should be more than 2 characters!")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Length(min = 3, message = "The name of the race should be more than 2 characters!")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Min(value = 0, message = "The cars must be at least 2!")
    public int getCarsCapacity() {
        return carsCapacity;
    }

    public void setCarsCapacity(int carsCapacity) {
        this.carsCapacity = carsCapacity;
    }

    @Min(value = 0,message = "Your race should be at least one lap!")
    public int getLaps() {
        return laps;
    }

    public void setLaps(int laps) {
        this.laps = laps;
    }
    @Min(value = 0,message = "Please enter valid lap range! ")
    public int getLapRange() {
        return lapRange;
    }

    public void setLapRange(int lapRange) {
        this.lapRange = lapRange;
    }
}
