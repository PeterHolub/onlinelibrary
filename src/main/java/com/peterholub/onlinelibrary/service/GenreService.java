package com.peterholub.onlinelibrary.service;

import com.peterholub.onlinelibrary.model.Genre;

import java.io.Serializable;
import java.util.List;

public interface GenreService {

    Genre getGenre(Serializable id);

    void saveGenre(Genre genre);

    void deleteGenre(Serializable id);

    List<Genre> getAllGenres();
}
