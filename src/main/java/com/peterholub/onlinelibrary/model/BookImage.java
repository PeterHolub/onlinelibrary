package com.peterholub.onlinelibrary.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "books_image")
@Getter
@Setter
public class BookImage {

    @Id
    @Column(name = "book_id")
    @Basic(optional = false)
    private Long bookId;

    @Column(name = "image")
    private byte[] image;
}
