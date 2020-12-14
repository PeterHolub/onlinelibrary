package com.peterholub.onlinelibrary.service;

import com.peterholub.onlinelibrary.model.Favorites;
import com.peterholub.onlinelibrary.model.key.FavoritesKey;

import java.util.Optional;

public interface FavoritesService {

    Optional<Favorites> getFavorites(FavoritesKey id);

    void saveFavorites(Favorites favorites);

    void deleteFavorites(FavoritesKey id);

}
