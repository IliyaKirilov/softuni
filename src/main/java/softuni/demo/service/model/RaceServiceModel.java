package softuni.demo.service.model;

import softuni.demo.domain.model.User;

import java.time.LocalDateTime;
import java.util.List;

public class RaceServiceModel  {
    private String id;
    private String country;
    private String city;
    private String name;
    private int carsCapacity;
    private int laps;
    private int lapRange;
    private List<User> racers;
    private boolean hasEnded;
    private LocalDateTime startedOn;
    private LocalDateTime dueDate;



    public LocalDateTime getStartedOn() {
        return startedOn;
    }

    public void setStartedOn(LocalDateTime startedOn) {
        this.startedOn = startedOn;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public RaceServiceModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCarsCapacity() {
        return carsCapacity;
    }

    public void setCarsCapacity(int carsCapacity) {
        this.carsCapacity = carsCapacity;
    }

    public int getLaps() {
        return laps;
    }

    public void setLaps(int laps) {
        this.laps = laps;
    }

    public int getLapRange() {
        return lapRange;
    }

    public void setLapRange(int lapRange) {
        this.lapRange = lapRange;
    }

    public List<User> getRacers() {
        return racers;
    }

    public void setRacers(List<User> racers) {
        this.racers = racers;
    }

    public boolean isHasEnded() {
        return hasEnded;
    }

    public void setHasEnded(boolean hasEnded) {
        this.hasEnded = hasEnded;
    }
}
