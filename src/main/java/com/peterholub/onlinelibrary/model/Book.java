package com.peterholub.onlinelibrary.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "books")
@Getter
@Setter
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
}
