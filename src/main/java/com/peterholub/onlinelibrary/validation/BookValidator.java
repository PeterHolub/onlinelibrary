package com.peterholub.onlinelibrary.validation;

import com.peterholub.onlinelibrary.model.Author;
import com.peterholub.onlinelibrary.model.Book;
import com.peterholub.onlinelibrary.model.Genre;
import com.peterholub.onlinelibrary.service.AuthorService;
import com.peterholub.onlinelibrary.service.GenreService;
import lombok.Getter;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Getter
public class BookValidator implements Validator {

    private final AuthorService authorService;
    private final GenreService genreService;

    public BookValidator(
    AuthorService authorService,
    GenreService genreService) {
        this.authorService = authorService;
        this.genreService = genreService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Book.class.equals(clazz);
    }

    @Override
    public void validate(
    Object target, Errors errors) {
        Book book = (Book) target;
        List<Long> wrongGenreIds = getWrongGenreIds(book);
        List<Long> wrongAuthorIds = getWrongAuthorIds(book);

        if (book.getGenres().isEmpty()) {
            errors.rejectValue("genres", "", "Book genres is required");
        } else if (!wrongGenreIds.isEmpty()) {
            errors.rejectValue("genres", "",
            "Genres with id:" + wrongIdsToString(wrongGenreIds) + " " +
            " doesnt exist");
        }

        if (book.getAuthors().isEmpty()) {
            errors.rejectValue("authors", "", "Book authors is required");
        } else if (!wrongGenreIds.isEmpty()) {
            errors.rejectValue("authors", "",
            "Authors with id:" + wrongIdsToString(wrongAuthorIds) + " " +
            " doesnt exist");
        }
    }

    private String wrongIdsToString(List<Long> wrongGenreIds) {
        StringBuilder wrongIds = new StringBuilder(" ");
        for (Long wrongId :
        wrongGenreIds) {
            wrongIds.append(wrongId);
        }
        return wrongIds.toString();
    }

    private List<Long> getWrongGenreIds(Book book) {
        return book.getGenres()
        .stream()
        .filter(
        genre -> getGenreService().getGenre(genre.getGenreId()).isEmpty())
        .map(
        Genre::getGenreId)
        .collect(Collectors.toList());
    }

    private List<Long> getWrongAuthorIds(Book book) {
        return book.getAuthors()
        .stream()
        .filter(
        author -> getAuthorService().getAuthor(author.getAuthorId()).isEmpty())
        .map(
        Author::getAuthorId)
        .collect(Collectors.toList());
    }

}
