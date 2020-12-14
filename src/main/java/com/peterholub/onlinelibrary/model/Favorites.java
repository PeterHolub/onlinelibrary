package com.peterholub.onlinelibrary.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.peterholub.onlinelibrary.model.key.FavoritesKey;
import com.voodoodyne.jackson.jsog.JSOGGenerator;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name = "favorites")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonIdentityInfo(generator = JSOGGenerator.class)
public class Favorites {

    @EmbeddedId
    @EqualsAndHashCode.Include
    private FavoritesKey key;

    @ManyToOne
    @MapsId("user_id")
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @MapsId("book_id")
    @JoinColumn(name = "book_id")
    private Book book;

    @Column(name = "user_rating")
    @Min(1)
    @Max(10)
    private Integer userRating;
}
