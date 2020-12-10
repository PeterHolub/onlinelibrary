package com.peterholub.onlinelibrary.model.key;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class BookGenreKey implements Serializable {

    @Column(name = "book_id")
    private Long bookId;
    @Column(name = "genre_id")
    private Long genreId;
}
