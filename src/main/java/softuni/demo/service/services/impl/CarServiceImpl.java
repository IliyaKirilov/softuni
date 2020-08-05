package softuni.demo.service.services.impl;



import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.demo.domain.model.Car;
import softuni.demo.domain.model.User;
import softuni.demo.domain.repository.CarRepository;
import softuni.demo.service.model.CarServiceModel;
import softuni.demo.service.model.UserServiceModel;
import softuni.demo.service.services.CarService;
import softuni.demo.service.services.UserService;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {

    private final UserService userService;
private final ModelMapper modelMapper;
private final CarRepository carRepository;


@Autowired
    public CarServiceImpl(UserService userService, ModelMapper modelMapper, CarRepository carRepository) {
    this.userService = userService;
    this.modelMapper = modelMapper;
        this.carRepository = carRepository;
    }


    @Override
    public CarServiceModel saveCar(CarServiceModel carServiceModel, Principal principal) {


        UserServiceModel userServiceModel = this.userService.findByUsername(principal.getName());
        userServiceModel.getCars().add(carServiceModel);
        User user = this.modelMapper.map(userServiceModel, User.class);

        this.userService.save(user);

        Car car = this.modelMapper.map(carServiceModel, Car.class);
        return this.modelMapper.map(car,CarServiceModel.class);

    }

    @Override
    public List<CarServiceModel> findAll() {
        return this.carRepository.findAll().stream()
                .map(car -> this.modelMapper.map
                        (car,CarServiceModel.class)).collect(Collectors.toList());
    }

    @Override
    public CarServiceModel findById(String id) {
        return this.carRepository.findById(id)
                .map(car -> this.modelMapper.map(car,CarServiceModel.class)).orElse(null);
    }

}
