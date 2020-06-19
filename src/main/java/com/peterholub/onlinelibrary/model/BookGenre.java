package com.peterholub.onlinelibrary.model;

import com.peterholub.onlinelibrary.model.key.BookGenreKey;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "book_genre")
public class BookGenre {
    @EmbeddedId
    private BookGenreKey key;
    @ManyToOne
    @MapsId("book_id")
    @JoinColumn(name = "book_id")
    private Book book;
    @ManyToOne
    @MapsId("genre_id")
    @JoinColumn(name = "genre_id")
    private Genre genre;

    public BookGenreKey getKey() {
        return key;
    }

    public void setKey(BookGenreKey key) {
        this.key = key;
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
        BookGenre bookGenre = (BookGenre) o;
        return Objects.equals(key, bookGenre.key) &&
                Objects.equals(book, bookGenre.book) &&
                Objects.equals(genre, bookGenre.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, book, genre);
    }
}
