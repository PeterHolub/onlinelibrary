CREATE TABLE public.books
(
    id              SERIAL PRIMARY KEY,
    name            VARCHAR(250) NOT NULL,
    description     VARCHAR(250),
    author_id       INTEGER,
    book_image_id   INTEGER,
    book_content_id INTEGER
);
ALTER TABLE public.books
    OWNER TO postgres;