package com.peterholub.onlinelibrary.service;

import com.peterholub.onlinelibrary.model.BookImage;

import java.util.Optional;

public interface BookImageService {

    Optional<BookImage> getBookImage(Long bookId);

    void saveBookImage(BookImage bookImage);

}
