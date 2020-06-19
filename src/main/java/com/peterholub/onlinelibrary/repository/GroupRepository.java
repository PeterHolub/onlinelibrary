package com.peterholub.onlinelibrary.repository;

import com.peterholub.onlinelibrary.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Long> {
}
