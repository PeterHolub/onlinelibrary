package com.peterholub.onlinelibrary.service.impl;

import com.peterholub.onlinelibrary.model.Book;
import com.peterholub.onlinelibrary.repository.BookRepository;
import com.peterholub.onlinelibrary.service.BookService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Getter
public class BookServiceImpl implements BookService {

    final private BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(
    BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Optional<Book> getBook(Long id) {
        return getBookRepository().findById(id);
    }

    @Override
    public void saveBook(Book book) {
        getBookRepository().save(book);
    }

    @Override
    public void deleteBook(Long id) {
        getBookRepository().deleteById(id);
    }

    @Override
    public List<Book> getAllBooks() {
        return getBookRepository().findAll();
    }
}
