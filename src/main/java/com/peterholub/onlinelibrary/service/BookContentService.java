package com.peterholub.onlinelibrary.service;

import com.peterholub.onlinelibrary.model.BookContent;

import java.util.Optional;

public interface BookContentService {

    Optional<BookContent> getBookContent(Long bookId);

    void saveBookContent(BookContent bookContent);
}
