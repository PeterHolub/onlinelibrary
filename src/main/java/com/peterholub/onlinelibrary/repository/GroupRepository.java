package com.peterholub.onlinelibrary.repository;

import com.peterholub.onlinelibrary.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Role, Long> {
}
