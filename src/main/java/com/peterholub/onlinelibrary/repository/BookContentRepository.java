package com.peterholub.onlinelibrary.repository;

import com.peterholub.onlinelibrary.model.BookContent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookContentRepository extends JpaRepository<BookContent, Long> {
}
