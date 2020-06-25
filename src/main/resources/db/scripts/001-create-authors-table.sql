CREATE TABLE public.authors
(
    id          SERIAL PRIMARY KEY,
    author_name VARCHAR(250) NOT NULL
);
ALTER TABLE public.authors
    OWNER TO postgres;
