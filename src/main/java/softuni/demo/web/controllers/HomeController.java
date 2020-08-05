package softuni.demo.web.controllers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import softuni.demo.domain.model.User;
import softuni.demo.service.model.UserServiceModel;
import softuni.demo.service.services.UserService;

import javax.servlet.http.HttpSession;
import java.security.Principal;

@Controller
public class HomeController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    @Autowired
    public HomeController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }


    @GetMapping("/home")
    public String home(Principal principal, Model model, HttpSession httpSession){

        String name = principal.getName();

        UserServiceModel user = this.modelMapper.map(this.userService.loadUserByUsername(name), UserServiceModel.class);
        model.addAttribute("user", user);
        System.out.println();
        model.addAttribute("brand",user.getBrand().toString().toLowerCase());
        return "home";
    }

    @GetMapping("/aboutUs")
    public String aboutUs(){


        return null;
    }

}
