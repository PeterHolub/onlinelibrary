package com.peterholub.onlinelibrary.controller;

import com.peterholub.onlinelibrary.exception.ValidationException;
import com.peterholub.onlinelibrary.model.User;
import com.peterholub.onlinelibrary.service.UserService;
import com.peterholub.onlinelibrary.validation.UserValidator;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@Getter
public class UserController {

    private final UserService userService;
    private final UserValidator userValidator;

    @Autowired
    public UserController(
    UserService userService,
    UserValidator userValidator) {
        this.userService = userService;
        this.userValidator = userValidator;
    }

    @InitBinder
    protected void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.setValidator(userValidator);
    }

    @GetMapping(value = "/user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        Optional<User> user = getUserService().getUser(id);
        return user.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
        .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(value = "/user/", consumes =
    MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> saveUser(
    @RequestBody @Valid User user, BindingResult bindingResult)
    throws ValidationException {
        if (bindingResult.hasErrors()) {
            throw new ValidationException("Exception on User saving",
            bindingResult.getAllErrors());
        } else
            getUserService().saveUser(user);
        return new ResponseEntity<>(user, HttpStatus.ACCEPTED);

    }

    @PutMapping(value = "/user/{id}", consumes =
    MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> updateUser(
    @PathVariable Long id, @RequestBody @Valid User user,
    BindingResult bindingResult) throws ValidationException {
        Optional<User> userFromDb = getUserService().getUser(id);
        if (userFromDb.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } else if (bindingResult.hasErrors()) {
            throw new ValidationException("Exception on User update",
            bindingResult.getAllErrors());
        } else
            getUserService().saveUser(user);
        return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/user/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> genres = getUserService().getAllUsers();
        if (genres.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else
            return new ResponseEntity<>(genres, HttpStatus.OK);
    }
}
