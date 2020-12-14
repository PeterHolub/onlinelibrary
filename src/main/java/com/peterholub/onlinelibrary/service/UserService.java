package com.peterholub.onlinelibrary.service;

import com.peterholub.onlinelibrary.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<User> getUser(Long id);

    void saveUser(User user);

    void deleteGroup(Long id);

    List<User> getAllUsers();
}
