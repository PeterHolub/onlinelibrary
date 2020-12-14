package com.peterholub.onlinelibrary.repository;

import com.peterholub.onlinelibrary.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
