package com.peterholub.onlinelibrary.validation;

import com.peterholub.onlinelibrary.model.User;
import com.peterholub.onlinelibrary.service.RoleService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Objects;

@Component
@Getter
public class UserValidator implements Validator {

    private final RoleService roleService;

    @Autowired
    public UserValidator(
    RoleService roleService) {
        this.roleService = roleService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(
    Object target, Errors errors) {
        User user = (User) target;
        if (Objects.isNull(user.getRole())) {

            errors.rejectValue("role", "", "User role is required");
        } else if (getRoleService().getRole(user.getRole().getId()).isEmpty()) {
            errors.rejectValue("role", "",
            "User role with id: " + user.getRole().getId() +
            " doesnt exist");
        }
    }
}
