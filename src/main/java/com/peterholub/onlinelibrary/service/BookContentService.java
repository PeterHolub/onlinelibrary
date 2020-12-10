package com.peterholub.onlinelibrary.service;

import com.peterholub.onlinelibrary.model.BookContent;

import java.io.Serializable;

public interface BookContentService {

    BookContent getBookContent(Serializable id);

    void saveBookContent(BookContent bookContent);

    void deleteBookContent(Serializable id);
}
