package com.peterholub.onlinelibrary.service;

import com.peterholub.onlinelibrary.model.Book;

import java.io.Serializable;
import java.util.List;

public interface BookService {

    Book getBook(Serializable id);

    void saveBook(Book book);

    void deleteBook(Serializable id);

    List<Book> getAllBooks();
}
