package softuni.demo.service.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.demo.domain.model.Role;
import softuni.demo.domain.repository.RoleRepository;
import softuni.demo.service.services.RoleService;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;


@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;


    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Set<Role> findAll() {
        return new HashSet<>(this.roleRepository.findAll());
    }

    // @PostConstruct// ?
    @Override
    public void initRoles() {
        this.roleRepository.saveAndFlush(new Role("ADMIN"));
        this.roleRepository.saveAndFlush(new Role("USER"));
    }

    @Override
    public Role findByAuthority(String authority) {

        Role byAuthority = this.roleRepository.findByAuthority(authority);

        System.out.println();
        return  byAuthority;
    }
}
