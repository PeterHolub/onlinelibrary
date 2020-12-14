package com.peterholub.onlinelibrary.controllers;

import com.peterholub.onlinelibrary.model.Author;
import com.peterholub.onlinelibrary.service.AuthorService;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
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

    @GetMapping("/author/{id}")
    public ResponseEntity<Author> getAuthor(@PathVariable Long id) {
        Optional<Author> author = getAuthorService().getAuthor(id);
        return author.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
        .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/author/")
    public ResponseEntity<Author> saveAuthor(
    @RequestBody @Valid Author author,
    BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            getAuthorService().saveAuthor(author);
            return new ResponseEntity<>(author, HttpStatus.ACCEPTED);
        }

    }

    @PutMapping("/author/{id}")
    public ResponseEntity<Author> updateAuthor(
    @PathVariable Long id, @RequestBody @Valid Author author,
    BindingResult bindingResult) {
        Optional<Author> authorFromDb = getAuthorService().getAuthor(id);
        if (authorFromDb.isPresent() && !bindingResult.hasErrors()) {
            getAuthorService().saveAuthor(author);
            return new ResponseEntity<>(author, HttpStatus.ACCEPTED);
        } else if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("/author/{id}")
    public ResponseEntity<Author> deleteAuthor(@PathVariable Long id) {
        Optional<Author> author = getAuthorService().getAuthor(id);
        if (author.isPresent()) {
            getAuthorService().deleteAuthor(id);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
