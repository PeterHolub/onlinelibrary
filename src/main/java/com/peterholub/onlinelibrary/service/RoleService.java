package com.peterholub.onlinelibrary.service;

import com.peterholub.onlinelibrary.model.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {

    Optional<Role> getRole(Long id);

    void saveRole(Role role);

    List<Role> getAllRoles();
}
