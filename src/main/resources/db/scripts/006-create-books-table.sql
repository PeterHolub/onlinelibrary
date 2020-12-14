CREATE TABLE public.books
(
    book_id     SERIAL PRIMARY KEY,
    name        VARCHAR(250) NOT NULL,
    description VARCHAR(1000)

);
ALTER TABLE public.books
    OWNER TO postgres;