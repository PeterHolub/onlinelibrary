package com.peterholub.onlinelibrary.service;

import com.peterholub.onlinelibrary.model.Role;

import java.io.Serializable;
import java.util.List;

public interface GroupService {

    Role getGroup(Serializable id);

    void saveGroup(Role role);

    void deleteGroup(Serializable id);

    List<Role> getAllGroups();
}
