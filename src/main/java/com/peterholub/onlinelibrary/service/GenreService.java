package com.peterholub.onlinelibrary.service;

import com.peterholub.onlinelibrary.model.Genre;

import java.io.Serializable;
import java.util.List;

public interface GenreService {
    Genre getGenre(Serializable id);

    void createGenre(Genre genre);

    void updateGenre(Genre genre);

    void deleteGenre(Serializable id);

    List<Genre> getAllGenres();
}
