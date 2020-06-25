CREATE TABLE public.books_content
(
    id      SERIAL PRIMARY KEY,
    book_id INTEGER,
    content bytea
);
ALTER TABLE public.books_content
    OWNER TO postgres;