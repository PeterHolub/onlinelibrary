package com.peterholub.onlinelibrary.service.impl;

import com.peterholub.onlinelibrary.model.BookContent;
import com.peterholub.onlinelibrary.repository.BookContentRepository;
import com.peterholub.onlinelibrary.service.BookContentService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Optional;

@Service
@Transactional
@Getter
public class BookContentServiceImpl implements BookContentService {

    final private BookContentRepository bookContentRepository;

    @Autowired
    public BookContentServiceImpl(
    BookContentRepository bookContentRepository) {
        this.bookContentRepository = bookContentRepository;
    }

    @Override
    public Optional<BookContent> getBookContent(Long bookId) {
        return getBookContentRepository().findById(bookId);
    }

    @Override
    public void saveBookContent(BookContent bookContent) {
        getBookContentRepository().save(bookContent);
    }
}
