package com.peterholub.onlinelibrary.service;

import com.peterholub.onlinelibrary.model.Group;

import java.io.Serializable;
import java.util.List;

public interface GroupService {
    Group getGroup(Serializable id);

    void createGroup(Group group);

    void updateGroup(Group group);

    void deleteGroup(Serializable id);

    List<Group> getAllGroups();
}
