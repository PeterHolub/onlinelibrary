package com.peterholub.onlinelibrary.service.impl;

import com.peterholub.onlinelibrary.model.BookImage;
import com.peterholub.onlinelibrary.repository.BookImageRepository;
import com.peterholub.onlinelibrary.service.BookImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.Serializable;

@Service
@Transactional
public class BookImageServiceImpl implements BookImageService {
    @Autowired
    private BookImageRepository bookImageRepository;

    @Override
    public BookImage getBookGenre(Serializable id) {
        return bookImageRepository.getOne((Long) id);
    }

    @Override
    public void createBookGenre(BookImage bookImage) {
        bookImageRepository.save(bookImage);
    }

    @Override
    public void updateBookGenre(BookImage bookImage) {
        bookImageRepository.save(bookImage);
    }

    @Override
    public void deleteBookGenre(Serializable id) {
        bookImageRepository.deleteById((Long) id);
    }
}
