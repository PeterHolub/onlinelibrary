package com.peterholub.onlinelibrary.service;

import com.peterholub.onlinelibrary.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    Optional<Book> getBook(Long id);

    void saveBook(Book book);

    void deleteBook(Long id);

    List<Book> getAllBooks();
}
