CREATE TABLE public.books_content
(
    book_id INTEGER PRIMARY KEY UNIQUE,
    content bytea
);
ALTER TABLE public.books_content
    OWNER TO postgres;