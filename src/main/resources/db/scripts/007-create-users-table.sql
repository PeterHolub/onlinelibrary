CREATE TABLE public.users
(
    id       SERIAL PRIMARY KEY,
    login    VARCHAR(70) NOT NULL,
    password VARCHAR(100) NOT NULL,
    role_id  INTEGER,
    is_active boolean,
    email VARCHAR (100)
);
ALTER TABLE public.users
    OWNER TO postgres;
