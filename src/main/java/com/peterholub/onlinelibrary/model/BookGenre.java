package com.peterholub.onlinelibrary.model;

import com.peterholub.onlinelibrary.model.key.BookGenreKey;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "books_genres")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
public class BookGenre {

    @EmbeddedId
    @EqualsAndHashCode.Include
    private BookGenreKey key;
    @ManyToOne
    @MapsId("book_id")
    @JoinColumn(name = "book_id")
    private Book book;
    @ManyToOne
    @MapsId("genre_id")
    @JoinColumn(name = "genre_id")
    private Genre genre;
}
