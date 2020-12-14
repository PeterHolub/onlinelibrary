package com.peterholub.onlinelibrary.service.impl;

import com.peterholub.onlinelibrary.model.BookImage;
import com.peterholub.onlinelibrary.repository.BookImageRepository;
import com.peterholub.onlinelibrary.service.BookImageService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
@Getter
public class BookImageServiceImpl implements BookImageService {

    final private BookImageRepository bookImageRepository;

    @Autowired
    public BookImageServiceImpl(
    BookImageRepository bookImageRepository) {
        this.bookImageRepository = bookImageRepository;
    }

    @Override
    public Optional<BookImage> getBookImage(Long bookId) {
        return getBookImageRepository().findById(bookId);
    }

    @Override
    public void saveBookImage(BookImage bookImage) {
        getBookImageRepository().save(bookImage);
    }

}
