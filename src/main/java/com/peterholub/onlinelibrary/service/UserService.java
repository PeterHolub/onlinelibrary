package com.peterholub.onlinelibrary.service;

import com.peterholub.onlinelibrary.model.User;

import java.io.Serializable;
import java.util.List;

public interface UserService {

    User getUser(Serializable id);

    void saveUser(User user);

    void deleteGroup(Serializable id);

    List<User> getAllUsers();
}
