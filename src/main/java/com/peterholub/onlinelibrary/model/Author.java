package com.peterholub.onlinelibrary.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Entity
@Table(name = "authors")
@Getter
@Setter
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private Long authorId;
    @Column(name = "author_name")
    @NotEmpty
    private String authorName;
    @ManyToMany(mappedBy = "authors")
    private Set<Book> books;
}
