package com.peterholub.onlinelibrary.service.impl;

import com.peterholub.onlinelibrary.model.Role;
import com.peterholub.onlinelibrary.repository.GroupRepository;
import com.peterholub.onlinelibrary.service.GroupService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Getter
public class GroupServiceImpl implements GroupService {

    final private GroupRepository groupRepository;

    @Autowired
    public GroupServiceImpl(
    GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public Optional<Role> getGroup(Long id) {
        return getGroupRepository().findById(id);
    }

    @Override
    public void saveGroup(Role role) {
        getGroupRepository().save(role);
    }

    @Override
    public void deleteGroup(Long id) {
        getGroupRepository().deleteById(id);
    }

    @Override
    public List<Role> getAllGroups() {
        return getGroupRepository().findAll();
    }
}
