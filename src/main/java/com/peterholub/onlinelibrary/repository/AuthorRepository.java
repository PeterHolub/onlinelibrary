package com.peterholub.onlinelibrary.repository;

import com.peterholub.onlinelibrary.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
