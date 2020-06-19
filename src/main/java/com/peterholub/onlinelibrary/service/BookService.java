package com.peterholub.onlinelibrary.service;

import com.peterholub.onlinelibrary.model.Book;

import java.io.Serializable;
import java.util.List;

public interface BookService {
    Book getBookGenre(Serializable id);

    void createBook(Book book);

    void updateBook(Book book);

    void deleteBook(Serializable id);

    List<Book> getAllBooks();
}
