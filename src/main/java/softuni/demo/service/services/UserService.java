package softuni.demo.service.services;

import org.springframework.security.core.userdetails.UserDetailsService;
import softuni.demo.domain.model.User;
import softuni.demo.service.model.UserServiceModel;

import java.util.List;

public interface UserService extends UserDetailsService {
    UserServiceModel findByUsername(String username);
    User registerUser(UserServiceModel userServiceModel);
    List<UserServiceModel> findAll();
    UserServiceModel findById(String id);
    User save(User user);
}
