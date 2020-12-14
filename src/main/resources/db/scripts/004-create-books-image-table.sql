CREATE TABLE public.books_image
(
    book_id INTEGER PRIMARY KEY UNIQUE,
    image   bytea
);
ALTER TABLE public.books_image
    OWNER TO postgres;