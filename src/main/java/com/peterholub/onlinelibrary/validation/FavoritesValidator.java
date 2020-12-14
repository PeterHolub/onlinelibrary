package com.peterholub.onlinelibrary.validation;

import com.peterholub.onlinelibrary.model.Favorites;
import com.peterholub.onlinelibrary.service.BookService;
import com.peterholub.onlinelibrary.service.UserService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Objects;

@Component
@Getter
public class FavoritesValidator implements Validator {

    private final UserService userService;

    private final BookService bookService;

    @Autowired
    public FavoritesValidator(
    UserService userService,
    BookService bookService) {
        this.userService = userService;
        this.bookService = bookService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Favorites.class.equals(clazz);
    }

    @Override
    public void validate(
    Object target, Errors errors) {
        Favorites favorites = (Favorites) target;

        if (Objects.isNull(favorites.getKey()) || (Objects.isNull(
        favorites.getKey().getBookId()) && Objects.isNull(
        favorites.getKey().getUserId()))) {
            errors.rejectValue("key",
            "", "Book id and User id " +
            "is required");
        } else {
            if (getBookService().getBook(favorites.getKey().getBookId())
            .isEmpty()) {
                errors.rejectValue("key.bookId", "",
                "Book with id: " + favorites.getKey()
                .getBookId() + " doesnt exist");
            }
            if (getBookService().getBook(favorites.getKey().getUserId())
            .isEmpty()) {
                errors.rejectValue("key.userId", "",
                "User with id: " + favorites.getKey()
                .getUserId() + " doesnt exist");
            }
        }
    }
}
