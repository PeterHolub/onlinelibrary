package com.peterholub.onlinelibrary.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.voodoodyne.jackson.jsog.JSOGGenerator;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "books_content")
@Getter
@Setter
@JsonIdentityInfo(generator = JSOGGenerator.class)
public class BookContent {

    @Id
    @Column(name = "book_id")
    @Basic(optional = false)
    private Long bookId;

    @Column(name = "content")
    private byte[] content;

}
