package com.peterholub.onlinelibrary.repository;

import com.peterholub.onlinelibrary.model.BookImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookImageRepository extends JpaRepository<BookImage,Long> {
}
