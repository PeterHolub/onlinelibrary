package com.peterholub.onlinelibrary.model;

import javax.persistence.*;

@Entity
@Table(name = "book_image")
public class BookImage {
    @Id
    @Column(name = "book_image_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(mappedBy = "bookImage")
    private Book book;
    @Column
    private byte[] image;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
