package com.peterholub.onlinelibrary.repository;

import com.peterholub.onlinelibrary.model.BookGenre;
import com.peterholub.onlinelibrary.model.key.BookGenreKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookGenreRepository extends JpaRepository<BookGenre, BookGenreKey> {
}
