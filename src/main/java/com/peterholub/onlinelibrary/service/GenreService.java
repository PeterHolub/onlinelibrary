package com.peterholub.onlinelibrary.service;

import com.peterholub.onlinelibrary.model.Genre;

import java.util.List;
import java.util.Optional;

public interface GenreService {

    Optional<Genre> getGenre(Long id);

    void saveGenre(Genre genre);

    void deleteGenre(Long id);

    List<Genre> getAllGenres();
}
