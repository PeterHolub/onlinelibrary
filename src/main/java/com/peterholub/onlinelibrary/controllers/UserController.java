package com.peterholub.onlinelibrary.controllers;

import com.peterholub.onlinelibrary.model.User;
import com.peterholub.onlinelibrary.service.UserService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
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
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(
    UserService userService) {
        this.userService = userService;
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
    @RequestBody @Valid User user) {
        getUserService().saveUser(user);
        return new ResponseEntity<>(user, HttpStatus.ACCEPTED);

    }

    @PutMapping(value = "/user/{id}", consumes =
    MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> updateUser(
    @PathVariable Long id, @RequestBody @Valid User user) {
        Optional<User> userFromDb = getUserService().getUser(id);
        if (userFromDb.isPresent()) {
            getUserService().saveUser(user);
            return new ResponseEntity<>(user, HttpStatus.ACCEPTED);

        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

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
