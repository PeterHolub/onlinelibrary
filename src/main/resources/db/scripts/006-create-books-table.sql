CREATE TABLE public.books
(
    id          SERIAL PRIMARY KEY,
    name        VARCHAR(250) NOT NULL,
    description VARCHAR(1000),
    author_id   INTEGER
);
ALTER TABLE public.books
    OWNER TO postgres;