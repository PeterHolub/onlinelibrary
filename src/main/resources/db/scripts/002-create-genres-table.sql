CREATE TABLE public.genres
(
    genre_id SERIAL PRIMARY KEY,
    name VARCHAR(250) NOT NULL
);
ALTER TABLE public.genres
    OWNER TO postgres;