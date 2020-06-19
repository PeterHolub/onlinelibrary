package com.peterholub.onlinelibrary.model;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "books_content")
public class BookContent {
    @Id
    @Column(name = "book_content_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @OneToOne(mappedBy = "bookContent")
    private Book book;
    @Column
    private byte[] content;

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

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookContent that = (BookContent) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(book, that.book) &&
                Arrays.equals(content, that.content);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, book);
        result = 31 * result + Arrays.hashCode(content);
        return result;
    }
}
