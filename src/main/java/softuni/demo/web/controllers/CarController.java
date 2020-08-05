package softuni.demo.web.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import softuni.demo.domain.model.Offer;
import softuni.demo.service.model.CarServiceModel;
import softuni.demo.service.model.OfferServiceModel;
import softuni.demo.service.model.UserServiceModel;
import softuni.demo.service.services.CarService;
import softuni.demo.service.services.OfferService;
import softuni.demo.service.services.UserService;
import softuni.demo.web.model.CarAddModel;

import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
public class CarController {
    private final OfferService offerService;
    private final UserService userService;
    private final CarService carService;
    private final ModelMapper modelMapper;


    @Autowired
    public CarController(OfferService offerService, UserService userService, CarService carService, ModelMapper modelMapper) {
        this.offerService = offerService;
        this.userService = userService;
        this.carService = carService;
        this.modelMapper = modelMapper;
    }


    @GetMapping("/cars/all")
    public String allCars(@RequestParam("id") String id, Model model){
        UserServiceModel user = this.userService.findById(id);
        Set<CarServiceModel> cars = user.getCars();

        model.addAttribute("cars",cars);
        return "/car/view-cars";
    }

    @GetMapping("/cars/add")
    public String addCar(@Valid @ModelAttribute("carAddModel") CarAddModel carAddModel
            , BindingResult bindingResult,
                         Model model, Principal principal){

        String name = principal.getName();

        UserServiceModel user = this.modelMapper.map(this.userService.loadUserByUsername(name), UserServiceModel.class);
        model.addAttribute("brand",user.getBrand().toString().toLowerCase());

        model.addAttribute("carAddModel",carAddModel);
        return "car/add-car";
    }

    @PostMapping("cars/add")
    public String addCarConfirm(@Valid @ModelAttribute("carAddModel") CarAddModel carAddModel
                                , BindingResult bindingResult,
            Model model, Principal principal){

        String name = principal.getName();

        UserServiceModel user
                = this.modelMapper.map
                (this.userService.loadUserByUsername(name), UserServiceModel.class);


        if (bindingResult.hasErrors()){
            model.addAttribute("carAddModel", carAddModel);
            model.addAttribute("brand",user.getBrand().toString().toLowerCase());
            return "car/add-car";
        }else {
            model.addAttribute("carAddModel",carAddModel);

            this.carService.saveCar(this.modelMapper.map(carAddModel, CarServiceModel.class),principal);
//dobavqm dve koli wtF?
            return "redirect:/home";
        }


    }
}
