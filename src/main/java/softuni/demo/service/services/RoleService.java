package softuni.demo.service.services;

import softuni.demo.domain.model.Role;

import java.util.Set;

public interface RoleService {
    Set<Role> findAll();
    void initRoles();
    Role findByAuthority(String authority);
}
