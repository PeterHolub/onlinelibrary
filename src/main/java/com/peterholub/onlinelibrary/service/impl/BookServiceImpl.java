package com.peterholub.onlinelibrary.service.impl;

import com.peterholub.onlinelibrary.model.Book;
import com.peterholub.onlinelibrary.repository.BookRepository;
import com.peterholub.onlinelibrary.service.BookService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Service
@Transactional
@Getter
public class BookServiceImpl implements BookService {
    @Autowired
   private BookRepository bookRepository;

    @Override
    public Book getBook(Serializable id) {
        return getBookRepository().getOne((Long) id);
    }

    @Override
    public void saveBook(Book book) {
        getBookRepository().save(book);
    }

    @Override
    public void deleteBook(Serializable id) {
        getBookRepository().deleteById((Long) id);
    }

    @Override
    public List<Book> getAllBooks() {
        return getBookRepository().findAll();
    }
}
