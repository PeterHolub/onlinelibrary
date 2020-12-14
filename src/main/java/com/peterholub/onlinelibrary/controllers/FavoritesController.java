package com.peterholub.onlinelibrary.controllers;

import com.peterholub.onlinelibrary.exceptions.ValidationException;
import com.peterholub.onlinelibrary.model.Favorites;
import com.peterholub.onlinelibrary.model.key.FavoritesKey;
import com.peterholub.onlinelibrary.service.FavoritesService;
import com.peterholub.onlinelibrary.validation.FavoritesValidator;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@Getter
public class FavoritesController {

    private final FavoritesValidator favoritesValidator;
    private final FavoritesService favoritesService;

    @Autowired
    public FavoritesController(
    FavoritesValidator favoritesValidator,
    FavoritesService favoritesService) {
        this.favoritesValidator = favoritesValidator;
        this.favoritesService = favoritesService;
    }

    @InitBinder
    protected void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.setValidator(favoritesValidator);
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
    @RequestBody @Valid Favorites favorites, BindingResult bindingResult)
    throws ValidationException {
        if (bindingResult.hasErrors()) {
            throw new ValidationException("Error on Favorites saving",
            bindingResult.getAllErrors());
        } else
            getFavoritesService().saveFavorites(favorites);
        return new ResponseEntity<>(favorites, HttpStatus.CREATED);
    }

    @PutMapping("/favorites")
    public ResponseEntity<Favorites> updateFavorites(
    @ModelAttribute FavoritesKey key,
    @RequestBody @Valid Favorites favorites, BindingResult bindingResult)
    throws ValidationException {
        Optional<Favorites> favoritesFromDb =
        getFavoritesService().getFavorites(key);
        if (favoritesFromDb.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else if (bindingResult.hasErrors()) {
            throw new ValidationException("Error on Favorites saving",
            bindingResult.getAllErrors());
        } else
            getFavoritesService().saveFavorites(favorites);
        return new ResponseEntity<>(favorites, HttpStatus.ACCEPTED);
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
