package com.peterholub.onlinelibrary.service.impl;

import com.peterholub.onlinelibrary.model.User;
import com.peterholub.onlinelibrary.repository.UserRepository;
import com.peterholub.onlinelibrary.service.UserService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Getter
public class UserServiceImpl implements UserService {

    final private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(
    UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> getUser(Long id) {
        return getUserRepository().findById(id);
    }

    @Override
    public void saveUser(User user) {
        getUserRepository().save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return getUserRepository().findAll();
    }
}
