package com.peterholub.onlinelibrary.service.impl;

import com.peterholub.onlinelibrary.model.Role;
import com.peterholub.onlinelibrary.repository.GroupRepository;
import com.peterholub.onlinelibrary.service.GroupService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Service
@Transactional
@Getter
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupRepository groupRepository;

    @Override
    public Role getGroup(Serializable id) {
        return getGroupRepository().getOne((Long) id);
    }

    @Override
    public void saveGroup(Role role) {
        getGroupRepository().save(role);
    }

    @Override
    public void deleteGroup(Serializable id) {
        getGroupRepository().deleteById((Long) id);
    }

    @Override
    public List<Role> getAllGroups() {
        return getGroupRepository().findAll();
    }
}
