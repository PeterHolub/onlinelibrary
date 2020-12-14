package com.peterholub.onlinelibrary.model;

import com.peterholub.onlinelibrary.validation.ValidateAuthors;
import com.peterholub.onlinelibrary.validation.ValidateGenres;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Entity
@Table(name = "books")
@Getter
@Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long book_id;

    @NotEmpty
    @Column(name = "name")
    private String name;

    @NotEmpty
    @Column(name = "description")
    private String description;

    @ManyToMany
    @JoinTable(name = "book_authors", joinColumns = @JoinColumn(name = "book_id"),
    inverseJoinColumns = @JoinColumn(name = "author_id"))
    @ValidateAuthors
    private Set<Author> authors;

    @ManyToMany
    @JoinTable(name = "book_genres", joinColumns = @JoinColumn(name = "book_id"),
    inverseJoinColumns = @JoinColumn(name = "genre_id"))
    @ValidateGenres
    private Set<Genre> genres;

    @JoinColumn(name = "book_id", insertable = false, updatable = false)
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private BookContent bookContent;

    @JoinColumn(name = "book_id", insertable = false, updatable = false)
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private BookImage bookImage;

}
