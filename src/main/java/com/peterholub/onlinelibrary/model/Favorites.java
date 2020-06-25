package com.peterholub.onlinelibrary.model;

import com.peterholub.onlinelibrary.model.key.FavoritesKey;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "favorites")
public class Favorites {
    @EmbeddedId
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

    public Integer getUserRating() {
        return userRating;
    }

    public void setUserRating(Integer userRating) {
        this.userRating = userRating;
    }

    public FavoritesKey getKey() {
        return key;
    }

    public void setKey(FavoritesKey key) {
        this.key = key;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Favorites favorites = (Favorites) o;
        return Objects.equals(key, favorites.key) &&
                Objects.equals(user, favorites.user) &&
                Objects.equals(book, favorites.book) &&
                Objects.equals(userRating, favorites.userRating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, user, book, userRating);
    }
}
