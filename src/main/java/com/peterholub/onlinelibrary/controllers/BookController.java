package com.peterholub.onlinelibrary.controllers;

import com.peterholub.onlinelibrary.exceptions.ValidationException;
import com.peterholub.onlinelibrary.model.Book;
import com.peterholub.onlinelibrary.model.BookContent;
import com.peterholub.onlinelibrary.model.BookImage;
import com.peterholub.onlinelibrary.service.BookContentService;
import com.peterholub.onlinelibrary.service.BookImageService;
import com.peterholub.onlinelibrary.service.BookService;
import com.peterholub.onlinelibrary.validation.BookValidator;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@Getter
public class BookController {

    private final BookService bookService;
    private final BookContentService bookContentService;
    private final BookImageService bookImageService;
    private final BookValidator bookValidator;

    @InitBinder
    protected void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.setValidator(bookValidator);
    }

    @Autowired
    public BookController(
    BookService bookService,
    BookContentService bookContentService,
    BookImageService bookImageService,
    BookValidator bookValidator) {
        this.bookService = bookService;
        this.bookContentService = bookContentService;
        this.bookImageService = bookImageService;
        this.bookValidator = bookValidator;
    }

    @GetMapping(value = "/book/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Book> getBook(@PathVariable Long id) {
        Optional<Book> book = getBookService().getBook(id);
        return book.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
        .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping(value = "/book/image/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<BookImage> getBookImage(@PathVariable Long id) {
        Optional<BookImage> bookImage = getBookImageService().getBookImage(
        id);
        return bookImage.map(
        value -> new ResponseEntity<>(value, HttpStatus.OK))
        .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping(value = "/book/content/{id}", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<BookContent> getBookContent(@PathVariable Long id) {
        Optional<BookContent> bookContent = getBookContentService().getBookContent(
        id);
        return bookContent.map(
        value -> new ResponseEntity<>(value, HttpStatus.OK))
        .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(value = "/book/", produces =
    MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Book> saveBook(
    @RequestBody @Valid Book book, BindingResult bindingResult)
    throws ValidationException {
        if (bindingResult.hasErrors()) {
            throw new ValidationException("Error on Book saving",
            bindingResult.getAllErrors());
        } else
            getBookService().saveBook(book);
        return new ResponseEntity<>(book, HttpStatus.CREATED);

    }

    @PutMapping(value = "/book/{id}", consumes =
    MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Book> updateBook(
    @PathVariable Long id, @RequestBody @Valid Book book,
    BindingResult bindingResult) throws ValidationException {
        Optional<Book> bookFromDb = getBookService().getBook(id);
        if (bookFromDb.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else if (bindingResult.hasErrors()) {
            if (bindingResult.hasErrors()) {
                throw new ValidationException("Error on Book update",
                bindingResult.getAllErrors());
            }
        } else
            getBookService().saveBook(book);
        return new ResponseEntity<>(book, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/book/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable Long id) {
        Optional<Book> author = getBookService().getBook(id);
        if (author.isPresent()) {
            getBookService().deleteBook(id);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
