package com.peterholub.onlinelibrary.service;


import com.peterholub.onlinelibrary.model.BookImage;

import java.io.Serializable;

public interface BookImageService {
    BookImage getBookGenre(Serializable id);

    void createBookGenre(BookImage bookImage);

    void updateBookGenre(BookImage bookImage);

    void deleteBookGenre(Serializable id);
}
