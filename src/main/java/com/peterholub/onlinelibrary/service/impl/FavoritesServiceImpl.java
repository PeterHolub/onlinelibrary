package com.peterholub.onlinelibrary.service.impl;

import com.peterholub.onlinelibrary.model.Favorites;
import com.peterholub.onlinelibrary.model.key.FavoritesKey;
import com.peterholub.onlinelibrary.repository.FavoritesRepository;
import com.peterholub.onlinelibrary.service.FavoritesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.Serializable;

@Service
@Transactional
public class FavoritesServiceImpl implements FavoritesService {
    @Autowired
   private FavoritesRepository favoritesRepository;

    @Override
    public Favorites getFavorites(Serializable id) {
        return favoritesRepository.getOne((FavoritesKey) id);
    }

    @Override
    public void createFavorites(Favorites favorites) {
        favoritesRepository.save(favorites);
    }

    @Override
    public void updateFavorites(Favorites favorites) {
        favoritesRepository.save(favorites);
    }

    @Override
    public void deleteFavorites(Serializable id) {
        favoritesRepository.deleteById((FavoritesKey) id);
    }
}
