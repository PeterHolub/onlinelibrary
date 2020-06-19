package com.peterholub.onlinelibrary.model.key;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class FavoritesKey implements Serializable {
    @Column(name = "book_id")
    private Long bookId;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "user_rating")
    private Integer userRating;

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getUserRating() {
        return userRating;
    }

    public void setUserRating(Integer userRating) {
        this.userRating = userRating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FavoritesKey that = (FavoritesKey) o;
        return Objects.equals(bookId, that.bookId) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(userRating, that.userRating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, userId, userRating);
    }
}
