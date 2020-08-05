package softuni.demo.service.services;

import softuni.demo.service.model.CarServiceModel;

import java.security.Principal;
import java.util.List;

public interface CarService {

    CarServiceModel saveCar(CarServiceModel carServiceModel, Principal principal);
    List<CarServiceModel> findAll();

    CarServiceModel findById(String id);
}
