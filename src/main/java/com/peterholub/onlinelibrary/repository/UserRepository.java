package com.peterholub.onlinelibrary.repository;

import com.peterholub.onlinelibrary.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
