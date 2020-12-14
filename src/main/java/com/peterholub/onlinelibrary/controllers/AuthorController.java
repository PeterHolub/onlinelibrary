package com.peterholub.onlinelibrary.controllers;

import com.peterholub.onlinelibrary.model.Author;
import com.peterholub.onlinelibrary.service.AuthorService;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@Getter
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(
    AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping(value = "/author/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Author> getAuthor(@PathVariable Long id) {
        Optional<Author> author = getAuthorService().getAuthor(id);
        return author.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
        .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(value = "/author/", produces =
    MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Author> saveAuthor(
    @RequestBody @Valid Author author) {
        getAuthorService().saveAuthor(author);
        return new ResponseEntity<>(author, HttpStatus.ACCEPTED);

    }

    @PutMapping(value = "/author/{id}", consumes =
    MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Author> updateAuthor(
    @PathVariable Long id, @RequestBody @Valid Author author) {
        Optional<Author> authorFromDb = getAuthorService().getAuthor(id);
        if (authorFromDb.isPresent()) {
            getAuthorService().saveAuthor(author);
            return new ResponseEntity<>(author, HttpStatus.ACCEPTED);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @DeleteMapping(value = "/author/{id}")
    public ResponseEntity<Author> deleteAuthor(@PathVariable Long id) {
        Optional<Author> author = getAuthorService().getAuthor(id);
        if (author.isPresent()) {
            getAuthorService().deleteAuthor(id);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
