package com.peterholub.onlinelibrary.service;

import com.peterholub.onlinelibrary.model.Favorites;

import java.io.Serializable;


public interface FavoritesService {
    Favorites getFavorites(Serializable id);

    void createFavorites(Favorites favorites);

    void updateFavorites(Favorites favorites);

    void deleteFavorites(Serializable id);


}