package com.peterholub.onlinelibrary.service.impl;

import com.peterholub.onlinelibrary.model.Role;
import com.peterholub.onlinelibrary.repository.GroupRepository;
import com.peterholub.onlinelibrary.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Service
@Transactional
public class GroupServiceImpl implements GroupService {
    @Autowired
    private GroupRepository groupRepository;

    @Override
    public Role getGroup(Serializable id) {
        return groupRepository.getOne((Long) id);
    }

    @Override
    public void createGroup(Role role) {
        groupRepository.save(role);
    }

    @Override
    public void updateGroup(Role role) {
        groupRepository.save(role);
    }

    @Override
    public void deleteGroup(Serializable id) {
        groupRepository.deleteById((Long) id);
    }

    @Override
    public List<Role> getAllGroups() {
        return groupRepository.findAll();
    }
}
