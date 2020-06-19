package com.peterholub.onlinelibrary.model.key;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class BookGenreKey implements Serializable {
    @Column(name = "book_id")
    private Long bookId;
    @Column(name = "genre_id")
    private Long genreId;

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getGenreId() {
        return genreId;
    }

    public void setGenreId(Long genreId) {
        this.genreId = genreId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookGenreKey that = (BookGenreKey) o;
        return Objects.equals(bookId, that.bookId) &&
                Objects.equals(genreId, that.genreId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, genreId);
    }
}
