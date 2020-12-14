package com.peterholub.onlinelibrary.service.impl;

import com.peterholub.onlinelibrary.model.Genre;
import com.peterholub.onlinelibrary.repository.GenreRepository;
import com.peterholub.onlinelibrary.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class GenreServiceImpl implements GenreService {

    final private GenreRepository genreRepository;

    @Autowired
    public GenreServiceImpl(
    GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public Optional<Genre> getGenre(Long id) {
        return genreRepository.findById(id);
    }

    @Override
    public void saveGenre(Genre genre) {
        genreRepository.save(genre);
    }

    @Override
    public void deleteGenre(Long id) {
        genreRepository.deleteById(id);
    }

    @Override
    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }
}
