package softuni.demo.web.model.view;

import softuni.demo.domain.model.Car;
import softuni.demo.domain.model.Race;
import softuni.demo.service.model.RoleServiceModel;

import java.util.List;
import java.util.Set;

public class UserViewModel {
    private String id;
    private Set<Car> cars;
    private Race race;
    private String username;
    private Set<RoleServiceModel> authorities;

    public Set<RoleServiceModel> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<RoleServiceModel> authorities) {
        this.authorities = authorities;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Set<Car> getCars() {
        return cars;
    }
    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
