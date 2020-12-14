package com.peterholub.onlinelibrary.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "books_content")
@Getter
@Setter
public class BookContent {

    @Id
    @Column(name = "book_id")
    @Basic(optional = false)
    private Long bookId;

    @Column(name = "content")
    private byte[] content;

}
