package com.peterholub.onlinelibrary.service;

import com.peterholub.onlinelibrary.model.BookGenre;

import java.io.Serializable;

public interface BookGenreService {
    BookGenre getBookGenre(Serializable id);

    void createBookGenre(BookGenre bookGenre);

    void updateBookGenre(BookGenre bookGenre);

    void deleteBookGenre(Serializable id);
}
