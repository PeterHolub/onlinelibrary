package com.peterholub.onlinelibrary.service.impl;

import com.peterholub.onlinelibrary.model.User;
import com.peterholub.onlinelibrary.repository.UserRepository;
import com.peterholub.onlinelibrary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
   private UserRepository userRepository;

    @Override
    public User getUser(Serializable id) {
        return userRepository.getOne((Long) id);
    }

    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void updateGroup(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteGroup(Serializable id) {
        userRepository.deleteById((Long) id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
