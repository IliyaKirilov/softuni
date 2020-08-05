package softuni.demo.service.model;

import softuni.demo.domain.model.Car;
import softuni.demo.domain.model.Race;
import softuni.demo.domain.model.enums.Brand;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserServiceModel {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String username;
    private String password;
    private Set<RoleServiceModel> authorities;
    private Brand brand;
    private Set<CarServiceModel> cars;
    private Race race;


    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public Set<CarServiceModel> getCars() {
        return cars;
    }

    public void setCars(Set<CarServiceModel> cars) {
        this.cars = cars;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Set<RoleServiceModel> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<RoleServiceModel> authorities) {
        this.authorities = authorities;
    }

    public UserServiceModel() {
        this.cars = new HashSet<>();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
