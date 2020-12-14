package com.peterholub.onlinelibrary.service.impl;

import com.peterholub.onlinelibrary.model.Role;
import com.peterholub.onlinelibrary.repository.RoleRepository;
import com.peterholub.onlinelibrary.service.RoleService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Getter
public class RoleServiceImpl implements RoleService {

    final private RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(
    RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Optional<Role> getRole(Long id) {
        return getRoleRepository().findById(id);
    }

    @Override
    public void saveRole(Role role) {
        getRoleRepository().save(role);
    }

    @Override
    public List<Role> getAllRoles() {
        return getRoleRepository().findAll();
    }
}
