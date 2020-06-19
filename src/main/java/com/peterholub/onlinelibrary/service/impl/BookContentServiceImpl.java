package com.peterholub.onlinelibrary.service.impl;

import com.peterholub.onlinelibrary.model.BookContent;
import com.peterholub.onlinelibrary.repository.BookContentRepository;
import com.peterholub.onlinelibrary.service.BookContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.Serializable;

@Service
@Transactional
public class BookContentServiceImpl implements BookContentService {
    @Autowired
   private BookContentRepository bookContentRepository;

    @Override
    public BookContent getBookContent(Serializable id) {
        return bookContentRepository.getOne((Long) id);
    }

    @Override
    public void createBookContent(BookContent bookContent) {
        bookContentRepository.save(bookContent);
    }

    @Override
    public void updateBookContent(BookContent bookContent) {
        bookContentRepository.save(bookContent);
    }

    @Override
    public void deleteBookContent(Serializable id) {
        bookContentRepository.deleteById((Long) id);
    }
}
