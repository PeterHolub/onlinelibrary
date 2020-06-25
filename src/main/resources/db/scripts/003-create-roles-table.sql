CREATE TABLE public.roles
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(250) NOT NULL
);
ALTER TABLE public.roles
    OWNER TO postgres;