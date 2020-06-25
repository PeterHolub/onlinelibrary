CREATE TABLE public.users
(
    id       SERIAL PRIMARY KEY,
    login    VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    role_id  INTEGER
);
ALTER TABLE public.users
    OWNER TO postgres;
