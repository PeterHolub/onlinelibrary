package com.peterholub.onlinelibrary.controller;

import com.peterholub.onlinelibrary.model.Genre;
import com.peterholub.onlinelibrary.service.GenreService;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@Getter
public class GenreController {

    private final GenreService genreService;

    public GenreController(
    GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping(value = "/genre/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Genre> getGenre(@PathVariable Long id) {
        Optional<Genre> genre = getGenreService().getGenre(id);
        return genre.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
        .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(value = "/genre/", consumes =
    MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Genre> saveGenre(
    @RequestBody @Valid Genre genre) {
        getGenreService().saveGenre(genre);
        return new ResponseEntity<>(genre, HttpStatus.ACCEPTED);

    }

    @PutMapping(value = "/genre/{id}", consumes =
    MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Genre> updateGenre(
    @PathVariable Long id, @RequestBody @Valid Genre genre) {
        Optional<Genre> authorFromDb = getGenreService().getGenre(id);
        if (authorFromDb.isPresent()) {
            getGenreService().saveGenre(genre);
            return new ResponseEntity<>(genre, HttpStatus.ACCEPTED);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @DeleteMapping(value = "/genre/{id}")
    public ResponseEntity<Genre> deleteGenre(@PathVariable Long id) {
        Optional<Genre> author = getGenreService().getGenre(id);
        if (author.isPresent()) {
            getGenreService().deleteGenre(id);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/genre/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Genre>> getAllGenres() {
        List<Genre> genres = getGenreService().getAllGenres();
        if (genres.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else
            return new ResponseEntity<>(genres, HttpStatus.OK);
    }
}
