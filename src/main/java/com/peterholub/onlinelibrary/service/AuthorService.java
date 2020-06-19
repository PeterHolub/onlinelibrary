package com.peterholub.onlinelibrary.service;

import com.peterholub.onlinelibrary.model.Author;

import java.io.Serializable;
import java.util.List;

public interface AuthorService {
    Author getAuthor(Serializable id);

    void createAuthor(Author author);

    void updateAuthor(Author author);

    void deleteAuthor(Serializable id);

    List<Author> getAllAuthors();
}
