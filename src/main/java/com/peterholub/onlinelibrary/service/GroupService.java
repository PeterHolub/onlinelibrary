package com.peterholub.onlinelibrary.service;

import com.peterholub.onlinelibrary.model.Role;

import java.util.List;
import java.util.Optional;

public interface GroupService {

    Optional<Role> getGroup(Long id);

    void saveGroup(Role role);

    void deleteGroup(Long id);

    List<Role> getAllGroups();
}
