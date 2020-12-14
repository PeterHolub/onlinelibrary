CREATE TABLE public.roles
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(250) NOT NULL,
    is_active boolean
);
ALTER TABLE public.roles
    OWNER TO postgres;