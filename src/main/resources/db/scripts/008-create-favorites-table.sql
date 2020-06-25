CREATE TABLE public.favorites
(
    book_id     INTEGER NOT NULL,
    user_id     INTEGER NOT NULL,
    user_rating INTEGER,
    PRIMARY KEY (book_id, user_id)
);
ALTER TABLE public.favorites
    OWNER TO postgres;

