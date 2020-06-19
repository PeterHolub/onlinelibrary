package com.peterholub.onlinelibrary.repository;

import com.peterholub.onlinelibrary.model.Favorites;
import com.peterholub.onlinelibrary.model.key.FavoritesKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoritesRepository extends JpaRepository<Favorites, FavoritesKey> {

}
