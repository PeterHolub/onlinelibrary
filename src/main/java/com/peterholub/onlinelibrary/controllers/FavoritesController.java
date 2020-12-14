package com.peterholub.onlinelibrary.controllers;

import com.peterholub.onlinelibrary.model.Favorites;
import com.peterholub.onlinelibrary.model.key.FavoritesKey;
import com.peterholub.onlinelibrary.service.FavoritesService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@Getter
public class FavoritesController {

    private final FavoritesService favoritesService;

    @Autowired
    public FavoritesController(
    FavoritesService favoritesService) {
        this.favoritesService = favoritesService;
    }

    @GetMapping(value = "/favorites")
    public ResponseEntity<Favorites> getFavorites(
    @ModelAttribute FavoritesKey key) {
        Optional<Favorites> favorites = getFavoritesService().getFavorites(key);
        return favorites.map(
        value -> new ResponseEntity<>(value, HttpStatus.OK))
        .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/favorites")
    public ResponseEntity<Favorites> saveFavorites(
    @RequestBody @Valid Favorites favorites) {
        getFavoritesService().saveFavorites(favorites);
        return new ResponseEntity<>(favorites, HttpStatus.CREATED);
    }

    @PutMapping("/favorites")
    public ResponseEntity<Favorites> updateFavorites(
    @ModelAttribute FavoritesKey key,
    @RequestBody @Valid Favorites favorites) {
        Optional<Favorites> favoritesFromDb =
        getFavoritesService().getFavorites(key);
        if (favoritesFromDb.isPresent()) {
            getFavoritesService().saveFavorites(favorites);
            return new ResponseEntity<>(favorites, HttpStatus.ACCEPTED);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("/favorites")
    public ResponseEntity<Favorites> deleteFavorites(
    @ModelAttribute FavoritesKey key) {
        Optional<Favorites> favorites = getFavoritesService().getFavorites(key);
        if (favorites.isPresent()) {
            getFavoritesService().deleteFavorites(key);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
