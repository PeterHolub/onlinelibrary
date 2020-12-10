package com.peterholub.onlinelibrary.service;

import com.peterholub.onlinelibrary.model.BookImage;

import java.io.Serializable;

public interface BookImageService {

    BookImage getBookImage(Serializable id);

    void saveBookImage(BookImage bookImage);

    void deleteBookImage(Serializable id);
}
