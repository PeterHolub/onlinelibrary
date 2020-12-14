package com.peterholub.onlinelibrary.validation.impl;

import com.peterholub.onlinelibrary.model.Role;
import com.peterholub.onlinelibrary.service.RoleService;
import com.peterholub.onlinelibrary.validation.ValidateRole;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

@Component
@Getter
public class RoleValidator implements ConstraintValidator<ValidateRole,
Role> {

    private final RoleService roleService;

    @Autowired
    public RoleValidator(
    RoleService roleService) {
        this.roleService = roleService;
    }

    @Override
    public void initialize(
    ValidateRole constraintAnnotation) {

    }

    @Override
    public boolean isValid(
    Role value, ConstraintValidatorContext context) {
        Optional<Role> role =
        getRoleService().getRole(value.getId());
        return role.isPresent() && value.getIsActive();
    }
}
