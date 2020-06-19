package com.peterholub.onlinelibrary.repository;

import com.peterholub.onlinelibrary.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
