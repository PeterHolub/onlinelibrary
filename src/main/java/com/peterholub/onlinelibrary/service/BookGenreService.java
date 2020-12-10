package com.peterholub.onlinelibrary.service;

import com.peterholub.onlinelibrary.model.BookGenre;

import java.io.Serializable;

public interface BookGenreService {

    BookGenre getBookGenre(Serializable id);

    void saveBookGenre(BookGenre bookGenre);

    void deleteBookGenre(Serializable id);
}
