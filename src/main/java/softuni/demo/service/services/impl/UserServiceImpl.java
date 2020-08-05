package softuni.demo.service.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import softuni.demo.domain.model.User;
import softuni.demo.domain.repository.RoleRepository;
import softuni.demo.domain.repository.UserRepository;
import softuni.demo.service.model.UserServiceModel;
import softuni.demo.service.services.RoleService;
import softuni.demo.service.services.UserService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;
    private final RoleService roleService;
    private final ModelMapper modelMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleService roleService, ModelMapper modelMapper, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleService = roleService;

        this.modelMapper = modelMapper;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.userRepository.findByUsername(username).orElse(null);
    }

    @Override
    public UserServiceModel findByUsername(String username) {


       return this.userRepository.findByUsername(username)
                .map(user -> this.modelMapper.map(user,UserServiceModel.class)).orElse(null);

    }

    @Override
    public User registerUser(UserServiceModel userServiceModel) {

        User user = this.modelMapper.map(userServiceModel, User.class);

        if (this.userRepository.count() == 0) {
            this.roleService.initRoles();
            user.setAuthorities(this.roleService.findAll());
        }else {
            user.setAuthorities(new HashSet<>(Set.of(this.roleService.findByAuthority("USER"))));
        }

        user.setPassword(bCryptPasswordEncoder.encode(userServiceModel.getPassword()));
        return this.userRepository.saveAndFlush(user);

    }

    @Override
    public List<UserServiceModel> findAll() {
    return
            this.userRepository.
                    findAll().
                    stream()
                    .map(user -> this.modelMapper.map
                            (user,UserServiceModel.class)).collect(Collectors.toList());
    }

    @Override
    public UserServiceModel findById(String id) {
        return  this.userRepository.findById(id).
                map(user -> this.modelMapper.map(user,UserServiceModel.class)).orElse(null);
    }

    @Override
    public User save(User user) {

        System.out.println();
        return this.userRepository.save(user);
    }
}
