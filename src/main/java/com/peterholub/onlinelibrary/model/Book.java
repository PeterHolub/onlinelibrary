package com.peterholub.onlinelibrary.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    private Author author;
    @OneToOne(mappedBy = "book", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private BookContent bookContent;
    @OneToOne(mappedBy = "book", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private BookImage bookImage;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public BookContent getBookContent() {
        return bookContent;
    }

    public void setBookContent(BookContent bookContent) {
        this.bookContent = bookContent;
    }

    public BookImage getBookImage() {
        return bookImage;
    }

    public void setBookImage(BookImage bookImage) {
        this.bookImage = bookImage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id) &&
                Objects.equals(name, book.name) &&
                Objects.equals(description, book.description) &&
                Objects.equals(author, book.author) &&
                Objects.equals(bookContent, book.bookContent) &&
                Objects.equals(bookImage, book.bookImage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, author, bookContent, bookImage);
    }
}
