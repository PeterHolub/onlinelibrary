ALTER TABLE books_genres
    ADD FOREIGN KEY (book_id) REFERENCES books (id) ON UPDATE
        CASCADE
        ON DELETE CASCADE;
ALTER TABLE books_genres
    ADD FOREIGN KEY (genre_id) REFERENCES genres (id) ON UPDATE CASCADE ON
        DELETE
        CASCADE;

ALTER TABLE books
    ADD FOREIGN KEY (author_id) REFERENCES authors (id);


ALTER TABLE favorites
    ADD FOREIGN KEY (book_id) REFERENCES books (id) ON
        UPDATE CASCADE ON
        DELETE
        CASCADE;
ALTER TABLE favorites
    ADD FOREIGN KEY (user_id) REFERENCES users (id) ON
        UPDATE CASCADE ON
        DELETE
        CASCADE;
ALTER TABLE users
    ADD FOREIGN KEY (role_id) REFERENCES roles (id);

ALTER TABLE books_content
    ADD FOREIGN KEY (book_id) REFERENCES books (id) ON
        UPDATE CASCADE ON
        DELETE
        CASCADE;
ALTER TABLE books_image
    ADD FOREIGN KEY (book_id) REFERENCES books (id) ON
        UPDATE CASCADE ON
        DELETE
        CASCADE;
