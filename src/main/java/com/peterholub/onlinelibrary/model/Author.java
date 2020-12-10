package com.peterholub.onlinelibrary.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "authors")
@Getter
@Setter
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "author_name")
    private String authorName;
    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    private Set<Book> books;
}
