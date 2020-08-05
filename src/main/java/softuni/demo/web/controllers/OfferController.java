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
import softuni.demo.domain.model.Car;
import softuni.demo.domain.model.Offer;
import softuni.demo.service.model.CarServiceModel;
import softuni.demo.service.model.OfferServiceModel;
import softuni.demo.service.services.CarService;
import softuni.demo.service.services.OfferService;
import softuni.demo.web.model.OfferAddModel;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Set;

@Controller
public class OfferController {
    private final ModelMapper modelMapper;
    private final OfferService offerService;
    private final CarService carService;


    @Autowired
    public OfferController(ModelMapper modelMapper, OfferService offerService, CarService carService) {
        this.modelMapper = modelMapper;
        this.offerService = offerService;
        this.carService = carService;
    }

    @GetMapping("/offers/view")
    public String viewOffers(Model model) {

        boolean noOffers = true;
        Set<OfferServiceModel> offers = this.offerService.findAll();

        System.out.println();
        if (offers != null){
            model.addAttribute("offers",offers);
            noOffers=false;
        }


        model.addAttribute("noOffers", noOffers);


        return "/offer/offers-view";
    }

    @GetMapping("/offers/add")
    public String addOffer(@RequestParam("id") String id, @Valid @ModelAttribute("offerAddModel")
            OfferAddModel offerAddModel, Model model, HttpSession httpSession) {
        httpSession.setAttribute("carId", id);
        CarServiceModel carServiceModel = this.carService.findById(id);
        model.addAttribute("offerAddModel", offerAddModel);
        model.addAttribute("car", carServiceModel);
        return "/offer/offer-add";
    }

    @PostMapping("/offers/add")
    public String addOfferConfirm(@Valid @ModelAttribute("offerAddModel")
                                          OfferAddModel offerAddModel, BindingResult bindingResult,
                                  Model model
            , HttpSession httpSession) {


        if (bindingResult.hasErrors()) {
            //todo model.add
            //todo redirect
        }
        OfferServiceModel offerServiceModel =
                this.modelMapper.map(offerAddModel, OfferServiceModel.class);

        CarServiceModel
                carServiceModel = this.carService.findById
                (httpSession.getAttribute("carId").toString());


        offerServiceModel.setCar(carServiceModel);

        this.offerService.addOffer(offerServiceModel);

        return "redirect:/home";
    }
}
