package com.peterholub.onlinelibrary.service.impl;

import com.peterholub.onlinelibrary.model.Favorites;
import com.peterholub.onlinelibrary.model.key.FavoritesKey;
import com.peterholub.onlinelibrary.repository.FavoritesRepository;
import com.peterholub.onlinelibrary.service.FavoritesService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
@Getter
public class FavoritesServiceImpl implements FavoritesService {

    final private FavoritesRepository favoritesRepository;

    @Autowired
    public FavoritesServiceImpl(
    FavoritesRepository favoritesRepository) {
        this.favoritesRepository = favoritesRepository;
    }

    @Override
    public Optional<Favorites> getFavorites(FavoritesKey id) {
        return getFavoritesRepository().findById(id);
    }

    @Override
    public void saveFavorites(Favorites favorites) {
        getFavoritesRepository().save(favorites);
    }

    @Override
    public void deleteFavorites(FavoritesKey id) {
        getFavoritesRepository().deleteById(id);
    }
}
