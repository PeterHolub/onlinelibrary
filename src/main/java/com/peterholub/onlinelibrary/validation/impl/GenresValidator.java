package com.peterholub.onlinelibrary.validation.impl;

import com.peterholub.onlinelibrary.model.Genre;
import com.peterholub.onlinelibrary.repository.GenreRepository;
import com.peterholub.onlinelibrary.service.GenreService;
import com.peterholub.onlinelibrary.validation.ValidateGenres;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Set;

@Component
@Getter
public class GenresValidator implements ConstraintValidator<ValidateGenres,
Set<Genre>> {

    private final GenreService genreService;

    @Autowired
    public GenresValidator(
    GenreService genreService) {
        this.genreService = genreService;
    }

    @Override
    public void initialize(
    ValidateGenres constraintAnnotation) {

    }

    @Override
    public boolean isValid(
    Set<Genre> genres, ConstraintValidatorContext context) {
        return genres.stream()
        .noneMatch(
        genre -> getGenreService().getGenre(genre.getGenreId()).isEmpty());
    }
}
