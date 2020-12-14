package com.peterholub.onlinelibrary.validation.impl;

import com.peterholub.onlinelibrary.model.Author;
import com.peterholub.onlinelibrary.model.Genre;
import com.peterholub.onlinelibrary.service.AuthorService;
import com.peterholub.onlinelibrary.service.GenreService;
import com.peterholub.onlinelibrary.validation.ValidateAuthors;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Set;

@Component
@Getter
public class AuthorsValidator implements ConstraintValidator<ValidateAuthors,
Set<Author>> {

    private final AuthorService authorService;

    @Autowired
    public AuthorsValidator(
    AuthorService authorService) {
        this.authorService = authorService;
    }

    @Override
    public void initialize(
    ValidateAuthors constraintAnnotation) {

    }

    @Override
    public boolean isValid(
    Set<Author> authors, ConstraintValidatorContext context) {
        return authors.stream()
        .noneMatch(
        genre -> getAuthorService().getAuthor(genre.getAuthorId()).isEmpty());
    }
}