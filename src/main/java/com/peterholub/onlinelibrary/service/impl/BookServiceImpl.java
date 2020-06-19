package com.peterholub.onlinelibrary.service.impl;

import com.peterholub.onlinelibrary.model.Book;
import com.peterholub.onlinelibrary.repository.BookRepository;
import com.peterholub.onlinelibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Service
@Transactional
public class BookServiceImpl implements BookService {
    @Autowired
   private BookRepository bookRepository;

    @Override
    public Book getBookGenre(Serializable id) {
        return bookRepository.getOne((Long) id);
    }

    @Override
    public void createBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void updateBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void deleteBook(Serializable id) {
        bookRepository.deleteById((Long) id);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}
