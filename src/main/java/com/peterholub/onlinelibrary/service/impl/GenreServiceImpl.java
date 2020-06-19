package com.peterholub.onlinelibrary.service.impl;

import com.peterholub.onlinelibrary.model.Genre;
import com.peterholub.onlinelibrary.repository.GenreRepository;
import com.peterholub.onlinelibrary.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Service
@Transactional
public class GenreServiceImpl implements GenreService {
    @Autowired
  private   GenreRepository genreRepository;

    @Override
    public Genre getGenre(Serializable id) {
        return genreRepository.getOne((Long) id);
    }

    @Override
    public void createGenre(Genre genre) {
        genreRepository.save(genre);
    }

    @Override
    public void updateGenre(Genre genre) {
        genreRepository.save(genre);
    }

    @Override
    public void deleteGenre(Serializable id) {
        genreRepository.deleteById((Long) id);
    }

    @Override
    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }
}
