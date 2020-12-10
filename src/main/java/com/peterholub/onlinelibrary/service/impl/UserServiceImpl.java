package com.peterholub.onlinelibrary.service.impl;

import com.peterholub.onlinelibrary.model.User;
import com.peterholub.onlinelibrary.repository.UserRepository;
import com.peterholub.onlinelibrary.service.UserService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Service
@Transactional
@Getter
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUser(Serializable id) {
        return getUserRepository().getOne((Long) id);
    }

    @Override
    public void saveUser(User user) {
        getUserRepository().save(user);
    }

    @Override
    public void deleteGroup(Serializable id) {
        getUserRepository().deleteById((Long) id);
    }

    @Override
    public List<User> getAllUsers() {
        return getUserRepository().findAll();
    }
}
