package com.peterholub.onlinelibrary.service.impl;

import com.peterholub.onlinelibrary.model.Favorites;
import com.peterholub.onlinelibrary.model.key.FavoritesKey;
import com.peterholub.onlinelibrary.repository.FavoritesRepository;
import com.peterholub.onlinelibrary.service.FavoritesService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.Serializable;

@Service
@Transactional
@Getter
public class FavoritesServiceImpl implements FavoritesService {

    @Autowired
    private FavoritesRepository favoritesRepository;

    @Override
    public Favorites getFavorites(Serializable id) {
        return getFavoritesRepository().getOne((FavoritesKey) id);
    }

    @Override
    public void saveFavorites(Favorites favorites) {
        getFavoritesRepository().save(favorites);
    }

    @Override
    public void deleteFavorites(Serializable id) {
        getFavoritesRepository().deleteById((FavoritesKey) id);
    }
}
