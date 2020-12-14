package com.peterholub.onlinelibrary.service;

import com.peterholub.onlinelibrary.model.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    Optional<Author> getAuthor(Long id);

    void saveAuthor(Author author);

    void deleteAuthor(Long id);

    List<Author> getAllAuthors();
}
