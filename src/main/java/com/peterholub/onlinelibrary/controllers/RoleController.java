package com.peterholub.onlinelibrary.controllers;

import com.peterholub.onlinelibrary.model.Role;
import com.peterholub.onlinelibrary.service.RoleService;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@Getter
public class RoleController {

    private final RoleService roleService;

    public RoleController(
    RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping(value = "/role/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Role> getRole(@PathVariable Long id) {
        Optional<Role> role = getRoleService().getRole(id);
        return role.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
        .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(value = "/role/", consumes =
    MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Role> saveRole(
    @RequestBody @Valid Role role) {
        getRoleService().saveRole(role);
        return new ResponseEntity<>(role, HttpStatus.ACCEPTED);

    }

    @PutMapping("/role/{id}")
    public ResponseEntity<Role> updateRole(
    @PathVariable Long id, @RequestBody @Valid Role role) {
        Optional<Role> roleFromDB = getRoleService().getRole(id);
        if (roleFromDB.isPresent()) {
            getRoleService().saveRole(role);
            return new ResponseEntity<>(role, HttpStatus.ACCEPTED);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @GetMapping(value = "/role/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Role>> getSAllRoles() {
        List<Role> roles = getRoleService().getAllRoles();
        if (roles.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else
            return new ResponseEntity<>(roles, HttpStatus.OK);
    }
}
