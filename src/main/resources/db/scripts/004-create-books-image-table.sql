CREATE TABLE public.books_image
(
    id      SERIAL PRIMARY KEY,
    book_id INTEGER,
    image   bytea
);
ALTER TABLE public.books_image
    OWNER TO postgres;