package com.peterholub.onlinelibrary.model;

import com.peterholub.onlinelibrary.model.key.FavoritesKey;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "favorites")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Favorites {

    @EmbeddedId
    @EqualsAndHashCode.Include
    private FavoritesKey key;

    @ManyToOne
    @MapsId("user_id")
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @MapsId("book_id")
    @JoinColumn(name = "book_id")
    private Book book;

    @Column(name = "user_rating")
    private Integer userRating;
}
