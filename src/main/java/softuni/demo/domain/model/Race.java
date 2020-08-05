package softuni.demo.domain.model;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "races")
public class Race extends BaseEntity {
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

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @PastOrPresent(message = "The date cannot be in the future!")
    @Column(name = "started_on", nullable = false)
    public LocalDateTime getStartedOn() {
        return startedOn;
    }

    public void setStartedOn(LocalDateTime startedOn) {
        this.startedOn = startedOn;
    }

    @Column(name = "due_date", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @FutureOrPresent(message = "The date cannot be in the past!")
    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    @OneToMany(mappedBy = "race",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    public List<User> getRacers() {
        return racers;
    }

    public void setRacers(List<User> racers) {
        this.racers = racers;
    }

    @Column()
    public boolean isHasEnded() {
        return hasEnded;
    }

    public void setHasEnded(boolean hasEnded) {
        this.hasEnded = hasEnded;
    }

    public Race() {
    }

    @Column(nullable = false)
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Column(nullable = false)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    @Column(nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Column(nullable = false)
    public int getCarsCapacity() {
        return carsCapacity;
    }

    public void setCarsCapacity(int capacity) {
        this.carsCapacity = capacity;
    }
    @Column(nullable = false)
    public int getLaps() {
        return laps;
    }

    public void setLaps(int laps) {
        this.laps = laps;
    }
    @Column(nullable = false)
    public int getLapRange() {
        return lapRange;
    }

    public void setLapRange(int lapRange) {
        this.lapRange = lapRange;
    }
}
