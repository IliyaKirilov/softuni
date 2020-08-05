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
import org.springframework.web.servlet.ModelAndView;
import softuni.demo.domain.model.Race;
import softuni.demo.domain.model.User;
import softuni.demo.domain.model.enums.Brand;
import softuni.demo.service.model.RaceServiceModel;
import softuni.demo.service.model.RoleServiceModel;
import softuni.demo.service.model.UserServiceModel;
import softuni.demo.service.services.RaceService;
import softuni.demo.service.services.RoleService;
import softuni.demo.service.services.UserService;
import softuni.demo.web.model.UserRegisterModel;
import softuni.demo.web.model.view.UserViewModel;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class UserController {
    private final UserService userService;
    private final ModelMapper modelMapper;
    private final RaceService raceService;
    private final RoleService roleService;
    @Autowired
    public UserController(UserService userService, ModelMapper modelMapper, RaceService raceService, RoleService roleService) {
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.raceService = raceService;
        this.roleService = roleService;
    }


    @GetMapping("/register")
    private String register(@Valid @ModelAttribute("userRegisterModel")
                                    UserRegisterModel userRegisterModel, BindingResult bindingResult, Model model) {

        model.addAttribute("userRegisterModel", userRegisterModel);
        model.addAttribute("brands", Brand.values());
        return "user/register";
    }

    @PostMapping("/register")
    private String registerConfirm(@Valid @ModelAttribute("userRegisterModel")
                                           UserRegisterModel userRegisterModel, BindingResult bindingResult

            , Model model) {

        UserServiceModel byUsername = this.userService.findByUsername(userRegisterModel.getUsername());


        boolean alreadyExists = false;
        System.out.println();
        if (!userRegisterModel.getPassword().equals(userRegisterModel.getConfirmPassword())
                || bindingResult.hasErrors()) {
            model.addAttribute("userRegisterModel", userRegisterModel);
            model.addAttribute("brands", Brand.values());
            return "user/register";
        }

        if (byUsername != null){

            alreadyExists = true;
            model.addAttribute("alreadyExists", alreadyExists);
            model.addAttribute("brands", Brand.values());
            return "user/register";
        }


        this.userService.registerUser(this.modelMapper.map(userRegisterModel, UserServiceModel.class));
        model.addAttribute("userRegisterModel", userRegisterModel);

        return "redirect:/home";
    }


    @GetMapping("/profile")
    public String profile(Principal principal, ModelAndView modelAndView){


        UserServiceModel byUsername = this.userService.findByUsername(principal.getName());
        //addCarsToModelandView


        modelAndView.addObject("user", byUsername);

        return "user/profile";
    }


    @GetMapping("/users/view")
    public ModelAndView viewUsers(ModelAndView modelAndView){

        List<UserViewModel> allUsers
                = this.userService.findAll().stream().map(userServiceModel -> {
            return this.modelMapper.map(userServiceModel, UserViewModel.class);
        }).collect(Collectors.toList());

        modelAndView.addObject("users",allUsers);
        //todo create users-view html i nakraq da slojish na cars <a> koito da navigira kum car-detail
        System.out.println();
        modelAndView.setViewName("user/view-users");
        return modelAndView;
    }


    @GetMapping("/users/promote")
    public ModelAndView promoteUser(@RequestParam("id") String id, ModelAndView modelAndView){


        UserServiceModel user = this.userService.findById(id);
        user.setAuthorities(this.roleService.findAll().stream()
                .map(role -> this.modelMapper.map(role, RoleServiceModel.class)).collect(Collectors.toSet()));
        List<UserViewModel> allUsers
                = this.userService.findAll().stream().map(userServiceModel -> {
            return this.modelMapper.map(userServiceModel, UserViewModel.class);
        }).collect(Collectors.toList());
        modelAndView.addObject("users",
                allUsers);

        this.userService.save(this.modelMapper.map(user,User.class));

        modelAndView.setViewName("user/view-users");
        System.out.println();
        return  modelAndView;
    }


    @GetMapping("/users/stats")
    public String userStats(@RequestParam("id") String id,Model model){

        UserServiceModel user = this.userService.findById(id);

        model.addAttribute("user", user);

        System.out.println();


        return "user/user-details";
    }

    @GetMapping("/login")
    public String login() {
        return "user/login";
    }


    @GetMapping("/users/add/race")
    public String addRace(@RequestParam("id") String id,Model model,Principal principal){

        RaceServiceModel byId = this.raceService.findById(id);

        User user = this.modelMapper.map(this.userService.findByUsername(principal.getName()), User.class);


        user.setRace(this.modelMapper.map(byId, Race.class));
        this.userService.save(user);


        return "redirect:/home";
    }
}
