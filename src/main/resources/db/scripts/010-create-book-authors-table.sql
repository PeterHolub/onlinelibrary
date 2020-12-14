create table public.book_authors
(
    book_id  bigint not null,
    author_id bigint not null,
    primary key (book_id, author_id)
);
ALTER TABLE public.book_authors
    OWNER TO postgres;