create table public.books_genres
(
    book_id  bigint not null,
    genre_id bigint not null,
    primary key (book_id, genre_id)
);
ALTER TABLE public.books_genres
    OWNER TO postgres;