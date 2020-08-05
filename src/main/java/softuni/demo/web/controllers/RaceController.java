package softuni.demo.web.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import softuni.demo.domain.model.enums.Brand;
import softuni.demo.service.model.RaceServiceModel;
import softuni.demo.service.model.UserServiceModel;
import softuni.demo.service.services.RaceService;
import softuni.demo.service.services.UserService;
import softuni.demo.web.model.RaceAddModel;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
public class RaceController {

    private final RaceService raceService;
    private final ModelMapper modelMapper;
    private final UserService userService;


    @Autowired
    public RaceController(RaceService raceService, ModelMapper modelMapper, UserService userService) {
        this.raceService = raceService;
        this.modelMapper = modelMapper;
        this.userService = userService;
    }

    @GetMapping("/races/add")
    public String addRace(@Valid @ModelAttribute("raceAddModel")
                                            RaceAddModel raceAddModel, BindingResult bindingResult
                                ,Model model){

        model.addAttribute("raceAddModel",raceAddModel);
        return "race/race-add";

    }


    @PostMapping("/races/add")
    public String addRaceConfirm(@Valid @ModelAttribute("raceAddModel")
                                                   RaceAddModel raceAddModel, BindingResult bindingResult
            , Model model){

        if (bindingResult.hasErrors()){

            model.addAttribute("raceAddModel", raceAddModel);
            return "race/race-add";
        }else {

            RaceServiceModel raceServiceModel = this.raceService.findByName(raceAddModel.getName());


            if (raceServiceModel != null){
                model.addAttribute("alreadyExists", true);
                model.addAttribute("raceAddModel", raceAddModel);
                model.addAttribute("brands", Brand.values());
                return "race/race-add";
            }else {

                this.raceService.addRace(this.modelMapper.map(raceAddModel,RaceServiceModel.class));
                model.addAttribute("brands", Brand.values());
                return "redirect:/home";
            }

        }


    }


    @GetMapping("/races/join")
    public String joinRace(Model model, Principal principal){

        UserServiceModel username = this.userService.findByUsername(principal.getName());

        List<RaceServiceModel> allRaces = this.raceService.findAllRaces();

        model.addAttribute("races", allRaces);
        model.addAttribute("cars",username.getCars());
        return "race/race-join";
    }


    @GetMapping("/races/view")
    public String allRaces(Model model){

        List<RaceServiceModel> allRaces = this.raceService.findAllRaces();
        model.addAttribute("races", allRaces);

        System.out.println();

        return "race/race-view";
    }
}
